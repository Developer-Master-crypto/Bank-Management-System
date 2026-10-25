package org.ganesh;

import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniStatement extends JFrame {

    String pinnumber;
    JLabel bank, mini, card, balance;

    public MiniStatement(String pinnumber) {
        this.pinnumber = pinnumber;
        setTitle("Mini Statement");
        setLayout(null);

        bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 200, 20);
        add(bank);

        card = new JLabel();
        card.setBounds(20, 80, 360, 20);
        add(card);

        mini = new JLabel();
        mini.setBounds(20, 140, 360, 240);
        add(mini);

        balance = new JLabel();
        balance.setBounds(20, 400, 360, 20);
        add(balance);

        try {
            connjdbc con = new connjdbc();
            ResultSet rs = con.s.executeQuery("select * from login where pin = '" + pinnumber + "'");
            while (rs.next()) {
                String cardnumber = rs.getString("cardnumber");
                if (cardnumber != null && cardnumber.length() >= 16) {
                    card.setText("Card Number: " + cardnumber.substring(0, 4) + "XXXXXXXX" + cardnumber.substring(12));
                } else if (cardnumber != null) {
                    card.setText("Card Number: " + cardnumber);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            int bal = 0;
            connjdbc con = new connjdbc();
            ResultSet rs = con.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
            StringBuilder statement = new StringBuilder("<html>");
            while (rs.next()) {
                String type = rs.getString("type");
                String amount = rs.getString("amount");
                statement.append(rs.getString("date"))
                        .append("&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(type)
                        .append("&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(amount)
                        .append("<br><br>");
                if ("Deposit".equals(type)) {
                    bal += Integer.parseInt(amount);
                } else {
                    bal -= Integer.parseInt(amount);
                }
            }
            statement.append("</html>");
            mini.setText(statement.toString());
            balance.setText("Your Current Account Balance is Rs. " + bal);
        } catch (Exception e) {
            e.printStackTrace();
        }

        setSize(400, 650);
        setLocation(20, 20);
        getContentPane().setBackground(java.awt.Color.WHITE);
        // Fix: use DISPOSE_ON_CLOSE so closing this window does not shut down the whole app
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        javax.swing.JButton closeBtn = new javax.swing.JButton("Close");
        closeBtn.setBounds(20, 440, 100, 30);
        closeBtn.addActionListener(e -> dispose());
        add(closeBtn);

        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}
