package org.ganesh;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Withdrawl extends JFrame implements ActionListener {

    // private String pinnumber;
    // private double amount;
    ImageIcon i1, i3;
    Image i2;
    JLabel image, text;
    JButton withdraw, back;
    JTextField amount;
    String pinnumber;

    public Withdrawl(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
        

        i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        // Fix: null-safe image scaling to prevent NullPointerException if resource is missing
        i2 = i1.getImage() != null ? i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT) : null;
        i3 = i2 != null ? new ImageIcon(i2) : new ImageIcon();
        image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        text = new JLabel("Enter the amount you want to withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170, 300, 400, 20);
        image.add(text);

        amount = new JTextField();
        amount.setBounds(170, 350, 320, 25);
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        image.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355, 485, 150, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        
        // this.pinnumber = pinnumber;
        // this.amount = amount;
        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
        //getContentPane().setBackground(Color.white);
    }

    public void actionPerformed(ActionEvent ae) {
        // Handle button actions here
        if (ae.getSource() == withdraw) {
            // Handle withdraw action
            String amountText = amount.getText();
            String date = LocalDate.now().toString();
            if (amountText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter an amount to withdraw.");
            } else {
                try {
                    int withdrawAmount = Integer.parseInt(amountText);
                    if (withdrawAmount <= 0) {
                        JOptionPane.showMessageDialog(this, "Please enter a valid amount greater than zero.");
                        return;
                    }
                    connjdbc c = new connjdbc();
                    ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
                    int balance = 0;
                    while (rs.next()) {
                        if (rs.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(rs.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    if (balance < withdrawAmount) {
                        JOptionPane.showMessageDialog(this, "Insufficient Balance");
                        return;
                    }
                    String query = "insert into bank values('" + pinnumber + "', '" + date + "', 'Withdraw', '" + amountText + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(this, "Successfully Withdrawn: Rs" + withdrawAmount);
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid numeric amount.");
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Database error while processing the withdrawal.");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "An error occurred while processing the withdrawal.");
                    e.printStackTrace();
                }
            }
            
        } else if (ae.getSource() == back) {
            // Handle back action
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
            
        }
    }
    public static void main(String[] args) {
        new Withdrawl("");
    }
    
}
