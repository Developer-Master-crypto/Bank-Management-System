package org.ganesh;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Transaction extends JFrame implements ActionListener {
    ImageIcon i1, i3;
    Image i2;
    JLabel image,text;
    JButton deposit,withdraw,fastcash, ministatement,pinchange,balanceenquiry,exit;
    String pinnumber;

    Transaction(String pinnumber) {
        this.pinnumber=pinnumber;
        setLayout(null);
        i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
         
        text = new JLabel("Please select your Transaction");
        text.setBounds(215, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(e -> {
            // Deposit action handled here without leaking `this` from the constructor.
        });
        image.add(deposit);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355, 415, 150, 30);
        withdraw.addActionListener(e -> {
            // Deposit action handled here without leaking `this` from the constructor.
        }); 
        image.add(withdraw);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170, 450, 150, 30);
        fastcash.addActionListener(e -> {
            // Deposit action handled here without leaking `this` from the constructor.
        });
        image.add(fastcash);

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(355, 450, 150, 30);
        ministatement.addActionListener(e -> {
            // Deposit action handled here without leaking `this` from the constructor.
        });
        image.add(ministatement);
        
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(170, 485, 150, 30);
        pinchange.addActionListener(e -> {
            // Deposit action handled here without leaking `this` from the constructor.
        }); 
        image.add(pinchange);

        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(355, 485, 150, 30);
        balanceenquiry.addActionListener(e -> {
            // Deposit action handled here without leaking `this` from the constructor.
        });
        image.add(balanceenquiry);

        exit = new JButton("Exit");
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
        Transaction transaction = new Transaction("");
        transaction.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override 
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == exit) {
            System.exit(0);
        } else if(ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if(ae.getSource() == withdraw) {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        } else if(ae.getSource() == fastcash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if(ae.getSource() == ministatement) {
            new MiniStatement(pinnumber).setVisible(true);
        } else if(ae.getSource() == pinchange) {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if(ae.getSource() == balanceenquiry) {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }

    }

//     private void handleDeposit() {
//     // Deposit action handled cleanly here
// }
}
