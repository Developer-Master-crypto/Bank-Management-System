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
    JButton deposit,withdraw,fastcash, ministatement,pinchange,balanceenquiry,exit;
    String pinnumber;

    FastCash(String pinnumber) {
        this.pinnumber=pinnumber;
        setLayout(null);
        i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
         
        text = new JLabel("Select the amount you want to withdraw");
        text.setBounds(180, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        deposit = new JButton("Rs 100");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(e -> {
            // Deposit action handled here without leaking `this` from the constructor.
        });
        image.add(deposit);

        withdraw = new JButton("Rs 500");
        withdraw.setBounds(355, 415, 150, 30);
        withdraw.addActionListener(e -> {
            // Deposit action handled here without leaking `this` from the constructor.
        }); 
        image.add(withdraw);

        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(170, 450, 150, 30);
        fastcash.addActionListener(e -> {
            // Deposit action handled here without leaking `this` from the constructor.
        });
        image.add(fastcash);

        ministatement = new JButton("Rs 2000");
        ministatement.setBounds(355, 450, 150, 30);
        ministatement.addActionListener(e -> {
            // Deposit action handled here without leaking `this` from the constructor.
        });
        image.add(ministatement);
        
        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(170, 485, 150, 30);
        pinchange.addActionListener(e -> {
            // Deposit action handled here without leaking `this` from the constructor.
        }); 
        image.add(pinchange);

        balanceenquiry = new JButton("Rs 10000");
        balanceenquiry.setBounds(355, 485, 150, 30);
        balanceenquiry.addActionListener(e -> {
            // Deposit action handled here without leaking `this` from the constructor.
        });
        image.add(balanceenquiry);

        exit = new JButton("Back");
        exit.setBounds(255, 520, 150, 30);
        exit.addActionListener(e -> {
            // Deposit action handled here without leaking `this` from the constructor.
        });
        image.add(exit);

        setSize(900, 900);
        setLocation(300, 0);
        getContentPane().setBackground(Color.white);
        //setUndecorated(true);
        setVisible(true);

    }
    public static void main(String[] args) {
        // Transaction transaction = new Transaction("");
        // transaction.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FastCash fastCash = new FastCash("");
        fastCash.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override 
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == exit) {
            // System.exit(0);
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
         } else {
            String amount = ((JButton) ae.getSource()).getText().substring(3); // Extract the amount from the button text
            
            try {
                connjdbc con = new connjdbc();
                ResultSet rs = con.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()) {
                    if(rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(balance < Integer.parseInt(amount) && balance < 0 && ae.getSource() != exit) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                
                // @SuppressWarnings("unused")
                Date date = new Date();
                
                String query = "insert into bank values('"+pinnumber+"', '"+date+"', '"+amount+"', 'Withdrawl')";
                con.s.executeUpdate(query);
                if(ae.getSource() != exit) {
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }
                // JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Error occurred while processing the transaction.");
            }

         } 
             }

//     private void handleDeposit() {
//     // Deposit action handled cleanly here
// }

}
