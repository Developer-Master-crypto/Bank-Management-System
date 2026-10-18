package org.ganesh;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BalanceEnquiry extends JFrame implements ActionListener {
    ImageIcon i1, i3;
    Image i2;
    JLabel image;
    JButton back;
    String pinnumber;

    public BalanceEnquiry(String pinnumber) {
        this.pinnumber = pinnumber;
        setTitle("Balance Enquiry");
        setLayout(null);

        i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        i2 = i1.getImage() != null ? i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT) : null;
        i3 = i2 != null ? new ImageIcon(i2) : new ImageIcon();
        image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        int balance = 0;
        try {
            connjdbc con = new connjdbc();
            ResultSet rs = con.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel text = new JLabel("Your Current Account Balance is Rs " + balance);
        text.setBounds(170, 300, 400, 35);
        text.setForeground(java.awt.Color.WHITE);
        image.add(text);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
