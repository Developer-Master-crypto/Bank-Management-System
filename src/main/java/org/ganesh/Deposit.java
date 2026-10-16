package org.ganesh;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Deposit extends JFrame implements ActionListener {

    // private String pinnumber;
    // private double amount;
    ImageIcon i1, i3;
    Image i2;
    JLabel image, text;
    JButton deposit, back;
    JTextField amount;
    String pinnumber;

    public Deposit(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
        

         i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
         i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        text = new JLabel("Enter the amount you want to deposit");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170, 300, 400, 20);
        image.add(text);

        amount = new JTextField();
        amount.setBounds(170, 350, 320, 25);
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(355, 485, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

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
        if (ae.getSource() == deposit) {
            // Handle deposit action
            String amountText = amount.getText();
            Date date = new Date();
            if (amountText.isEmpty()) {
                // Show error message for empty amount
                JOptionPane.showMessageDialog(this, "Please enter an amount to deposit.");
            } else {
                try {
                    connjdbc c = new connjdbc();
                    String query = "insert into bank values('" + pinnumber + "', '" + date + "', 'Deposit', '" + amountText + "')";
					c.s.executeUpdate(query);
                    double depositAmount = Double.parseDouble(amountText);
                    if (depositAmount <= 0) {
                        // Show error message for invalid amount
                        JOptionPane.showMessageDialog(this, "Please enter a valid amount greater than zero.");
                    } else {
                        // Proceed with deposit logic
                        // For example, update the database with the new balance
                        // Assuming you have a method to handle the deposit
                        // updateBalance(pinnumber, depositAmount);
                        JOptionPane.showMessageDialog(this, "Successfully deposited: Rs" + depositAmount);
                        setVisible(false);
                        new Transaction(pinnumber).setVisible(true);
                    }
                } catch (NumberFormatException e) {
                    // Show error message for non-numeric input
                    JOptionPane.showMessageDialog(this, "Please enter a valid numeric amount.");
                } catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				} catch (Exception e) {
                    // Handle any other exceptions
                    JOptionPane.showMessageDialog(this, "An error occurred while processing the deposit.");
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
        new Deposit("");
    }
    
}
