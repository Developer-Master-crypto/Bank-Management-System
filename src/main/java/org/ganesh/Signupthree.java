package org.ganesh;


import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class Signupthree extends JFrame {
    JLabel l1,type,card,number,pin,pnumber,carddetails;
    JRadioButton saving,fixed,current,recurring;
    ButtonGroup accountgroup;
    Signupthree() {
        setLayout(null);
        l1 = new JLabel("Page 3: Account Details");
        l1.setBounds(280, 40, 400, 22);
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        add(l1);

        type = new JLabel("Account Type:");
        type.setBounds(100, 140, 200, 30);
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        add(type);

        saving = new JRadioButton("Saving Account");
        saving.setFont(new Font("Raleway",Font.BOLD,16));
        saving.setBounds(100, 180, 150, 20);
        saving.setBackground(Color.WHITE);
        add(saving);

        fixed = new JRadioButton("Fixed Deposit Account");
        fixed.setFont(new Font("Raleway",Font.BOLD,16));
        fixed.setBounds(350, 180, 150, 20);
        fixed.setBackground(Color.WHITE);
        add(fixed);

        current = new JRadioButton("Current Account");
        current.setFont(new Font("Raleway",Font.BOLD,16));
        current.setBounds(100, 220, 150, 20);
        current.setBackground(Color.WHITE);
        add(current);

        recurring = new JRadioButton("Recurring Deposit Account");
        recurring.setFont(new Font("Raleway",Font.BOLD,16));
        recurring.setBounds(350, 220, 150, 20);
        recurring.setBackground(Color.WHITE);
        add(recurring);

        accountgroup = new ButtonGroup();
        accountgroup.add(saving);
        accountgroup.add(fixed);
        accountgroup.add(current);
        accountgroup.add(recurring);

        card= new JLabel("Card Number:");
        card.setBounds(100, 300, 200, 30);
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        add(card);

        number = new JLabel("XXXX-XXXX-XXXX-1980");
        number.setBounds(330, 300, 300, 30);
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        add(number);

        carddetails= new JLabel("Your 16 Digits Card Number:");
        carddetails.setBounds(100, 330, 300, 30);
        carddetails.setFont(new Font("Raleway", Font.BOLD, 12));
        add(carddetails);

        pin= new JLabel("PIN:");
        pin.setBounds(100, 350, 200, 30);
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        add(pin);

        pnumber= new JLabel("XXXX");
        pnumber.setBounds(330, 350, 300, 30);
        pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        add(pnumber);



        setSize(820, 820);
        setLocation(350, 0);
        
        setVisible(true);

    }
    public static void main(String[] args) {
        new Signupthree();
    }
}
