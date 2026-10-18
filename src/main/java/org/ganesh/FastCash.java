package org.ganesh;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FastCash extends JFrame implements ActionListener {
    ImageIcon i1, i3;
    Image i2;
    JLabel image,text;
    JButton hundred, fiveHundred, thousand, twoThousand, fiveThousand, tenThousand, back;
    String pinnumber;

    FastCash(String pinnumber) {
        this.pinnumber=pinnumber;
        setLayout(null);
        i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        i2 = i1.getImage() != null ? i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT) : null;
        i3 = i2 != null ? new ImageIcon(i2) : new ImageIcon();
        image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
         
        text = new JLabel("Select the amount you want to withdraw");
        text.setBounds(180, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        hundred = new JButton("Rs 100");
        hundred.setBounds(170, 415, 150, 30);
        hundred.addActionListener(this);
        image.add(hundred);

        fiveHundred = new JButton("Rs 500");
        fiveHundred.setBounds(355, 415, 150, 30);
        fiveHundred.addActionListener(this);
        image.add(fiveHundred);

        thousand = new JButton("Rs 1000");
        thousand.setBounds(170, 450, 150, 30);
        thousand.addActionListener(this);
        image.add(thousand);

        twoThousand = new JButton("Rs 2000");
        twoThousand.setBounds(355, 450, 150, 30);
        twoThousand.addActionListener(this);
        image.add(twoThousand);
        
        fiveThousand = new JButton("Rs 5000");
        fiveThousand.setBounds(170, 485, 150, 30);
        fiveThousand.addActionListener(this);
        image.add(fiveThousand);

        tenThousand = new JButton("Rs 10000");
        tenThousand.setBounds(355, 485, 150, 30);
        tenThousand.addActionListener(this);
        image.add(tenThousand);

        back = new JButton("Back");
        back.setBounds(255, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    public static void main(String[] args) {
        FastCash fastCash = new FastCash("");
        fastCash.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
            return;
        }

        String amount = ((JButton) ae.getSource()).getText().substring(3).trim();

        try {
            connjdbc con = new connjdbc();
            ResultSet rs = con.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"))
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            int withdrawAmount = Integer.parseInt(amount);
            if (balance < withdrawAmount) {
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }

            Date date = new Date();
            String query = "insert into bank values('" + pinnumber + "', '" + date + "', 'Withdraw', '" + amount + "')";
            con.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred while processing the transaction.");
        }
    }
}
