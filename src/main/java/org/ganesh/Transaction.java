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
    JButton deposit,withdraw,fastcash;
    Transaction() {
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
        deposit.addActionListener(e -> handleDeposit());
        image.add(deposit);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(350, 415, 150, 30);
        withdraw.addActionListener(e -> {
            // Deposit action handled here without leaking `this` from the constructor.
        }); 
        image.add(withdraw);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(530, 415, 150, 30);
        fastcash.addActionListener(e -> {
            // Deposit action handled here without leaking `this` from the constructor.
        });
        image.add(fastcash);

        setSize(900, 900);
        setLocation(300, 0);
        getContentPane().setBackground(Color.white);
        //setUndecorated(true);
        setVisible(true);

    }
    public static void main(String[] args) {
        new Transaction();
    }
    @Override 
    public void actionPerformed(ActionEvent ae) {
        
    }

    private void handleDeposit() {
    // Deposit action handled cleanly here
}
}
