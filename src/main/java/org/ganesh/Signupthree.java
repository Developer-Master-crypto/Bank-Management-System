package org.ganesh;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JOptionPane;

public class Signupthree extends JFrame implements ActionListener {

    JLabel l1, type, card, number, pin, pnumber, carddetails, pindetails, services;
    JRadioButton saving, fixed, current, recurring;
    ButtonGroup accountgroup;
    JCheckBox atm, internet, mobile, email, cheque, eStatement,declare;
    JButton submit,cancel;
    String formno;

    Signupthree(String formno) {
        this.formno = formno;

        setLayout(null);

        l1 = new JLabel("Page 3: Account Details");
        l1.setBounds(280, 40, 400, 30);
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        add(l1);

        type = new JLabel("Account Type:");
        type.setBounds(100, 140, 200, 30);
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        add(type);

        saving = new JRadioButton("Saving Account");
        saving.setFont(new Font("Raleway", Font.BOLD, 16));
        saving.setBounds(100, 180, 150, 20);
        saving.setBackground(Color.WHITE);
        add(saving);

        fixed = new JRadioButton("Fixed Deposit Account");
        fixed.setFont(new Font("Raleway", Font.BOLD, 16));
        fixed.setBounds(350, 180, 250, 20);
        fixed.setBackground(Color.WHITE);
        add(fixed);

        current = new JRadioButton("Current Account");
        current.setFont(new Font("Raleway", Font.BOLD, 16));
        current.setBounds(100, 220, 150, 20);
        current.setBackground(Color.WHITE);
        add(current);

        recurring = new JRadioButton("Recurring Deposit Account");
        recurring.setFont(new Font("Raleway", Font.BOLD, 16));
        recurring.setBounds(350, 220, 250, 20);
        recurring.setBackground(Color.WHITE);
        add(recurring);

        accountgroup = new ButtonGroup();
        accountgroup.add(saving);
        accountgroup.add(fixed);
        accountgroup.add(current);
        accountgroup.add(recurring);

        card = new JLabel("Card Number:");
        card.setBounds(100, 300, 200, 30);
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        add(card);

        number = new JLabel("XXXX-XXXX-XXXX-1980");
        number.setBounds(330, 300, 300, 30);
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        add(number);

        carddetails = new JLabel("Your 16 Digits Card Number:");
        carddetails.setBounds(100, 330, 300, 30);
        carddetails.setFont(new Font("Raleway", Font.BOLD, 12));
        add(carddetails);

        pin = new JLabel("PIN:");
        pin.setBounds(100, 350, 200, 30);
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        add(pin);

        pnumber = new JLabel("XXXX");
        pnumber.setBounds(330, 350, 300, 30);
        pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        add(pnumber);

        pindetails = new JLabel("Your 4 Digit PIN:");
        pindetails.setBounds(100, 400, 300, 30);
        pindetails.setFont(new Font("Raleway", Font.BOLD, 12));
        add(pindetails);

        services = new JLabel("Services Required:");
        services.setBounds(100, 450, 230, 30);
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        add(services);

        atm = new JCheckBox("ATM Card");
        atm.setBackground(Color.WHITE); 
        atm.setFont(new Font("Raleway", Font.BOLD, 16));
        atm.setBounds(100, 500, 200, 30);
        add(atm);

        internet = new JCheckBox("Internet Banking");
        internet.setBackground(Color.WHITE);
        internet.setFont(new Font("Raleway", Font.BOLD, 16));
        internet.setBounds(350, 500, 200, 30);
        add(internet);

        mobile = new JCheckBox("Mobile Banking");
        mobile.setBackground(Color.WHITE);
        mobile.setFont(new Font("Raleway", Font.BOLD, 16));
        mobile.setBounds(100, 550, 200, 30);
        add(mobile);

        email = new JCheckBox("Email & SMS Alerts");
        email.setBackground(Color.WHITE);
        email.setFont(new Font("Raleway", Font.BOLD, 16));
        email.setBounds(350, 550, 200, 30);
        add(email);

        cheque = new JCheckBox("Cheque Book");
        cheque.setBackground(Color.WHITE);
        cheque.setFont(new Font("Raleway", Font.BOLD, 16));
        cheque.setBounds(100, 600, 200, 30);
        add(cheque);

        eStatement = new JCheckBox("E-Statement");
        eStatement.setBackground(Color.WHITE);
        eStatement.setFont(new Font("Raleway", Font.BOLD, 16));
        eStatement.setBounds(350, 600, 200, 30);
        add(eStatement);

        declare = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
        declare.setBounds(100, 700, 600, 30);   
        declare.setBackground(Color.WHITE);
        declare.setFont(new Font("Raleway", Font.BOLD, 12));
        add(declare);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250, 750, 100, 30);
        submit.addActionListener(this::actionPerformed);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(370, 750, 100, 30);
        cancel.addActionListener(this::actionPerformed);
        add(cancel);



        getContentPane().setBackground(Color.white);
        setSize(820, 820);
        setLocation(350, 0);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit ){
            String accountType = null;
            if (saving.isSelected()) {
                accountType = "Saving Account";
            } else if (fixed.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (current.isSelected()) {
                accountType = "Current Account";
            } else if (recurring.isSelected()) {
                accountType = "Recurring Deposit Account";
            } 
            Random random = new Random();
            String cardnumber = " " + Math.abs(random.nextLong()%90000000L+5040936000000000L);
            String pinnumber = " " + Math.abs((random.nextLong()%9000L+1000));
            String facility = " ";
            if(atm.isSelected()){
                facility = facility + "ATM CARD";
            } else if(internet.isSelected()){
                facility = facility + " Internet Banking";
            } else if(mobile.isSelected()){
                facility = facility + " Mobile Banking";
            } else if(email.isSelected()){
                facility = facility + " Email & SMS Alerts";
            } else if(cheque.isSelected()){
                facility = facility + " Cheque Book";
            } else if(eStatement.isSelected()){
                facility = facility + " E-Statement";
            } 

            try {
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                } else {
                    connjdbc c1 = new connjdbc();
                    String q1 = "insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String q2 = "insert into login values('"+cardnumber+"','"+pinnumber+"')";
                    c1.s.executeUpdate(q1);
                    c1.s.executeUpdate(q2);

                    JOptionPane.showMessageDialog(null, "Card Number: "+cardnumber+"\n Pin: "+pinnumber);

                    setVisible(false);
                    new Deposit(pinnumber, 0.0).setVisible(true);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == cancel) {

        }
    }
    public static void main(String[] args) {
        new Signupthree("");
    }
}
