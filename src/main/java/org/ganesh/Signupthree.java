package org.ganesh;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

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
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(370, 750, 100, 30);
        cancel.addActionListener(this);
        add(cancel);



        getContentPane().setBackground(Color.white);
        setSize(820, 820);
        setLocation(350, 0);

        setVisible(true);
    }
@Override
public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == submit) {
        String accountType = null;
        if (saving.isSelected())      accountType = "Saving Account";
        else if (fixed.isSelected())  accountType = "Fixed Deposit Account";
        else if (current.isSelected()) accountType = "Current Account";
        else if (recurring.isSelected()) accountType = "Recurring Deposit Account";

        if (accountType == null) {
            JOptionPane.showMessageDialog(null, "Account Type is Required");
            return;
        }
        if (!declare.isSelected()) {
            JOptionPane.showMessageDialog(null, "Please accept the declaration");
            return;
        }

        StringBuilder facility = new StringBuilder();
        if (atm.isSelected())       facility.append("ATM CARD ");
        if (internet.isSelected())  facility.append("Internet Banking ");
        if (mobile.isSelected())    facility.append("Mobile Banking ");
        if (email.isSelected())     facility.append("Email & SMS Alerts ");
        if (cheque.isSelected())    facility.append("Cheque Book ");
        if (eStatement.isSelected()) facility.append("E-Statement ");

        // 16-digit card number and 4-digit PIN
        long cardValue = 1000000000000000L + Math.floorMod(new Random().nextLong(), 9000000000000000L);
        String cardnumber = String.valueOf(cardValue);
        String pinnumber = String.format("%04d", new Random().nextInt(10000));
// int formNumber;
// try {
//     formNumber = Integer.parseInt(formno.trim());
// } catch (NumberFormatException e) {
//     JOptionPane.showMessageDialog(null, "Invalid form number: '" + formno + "'");
//     return;
// }
        try {
    connjdbc c1 = new connjdbc();

    try (PreparedStatement ps1 = c1.con.prepareStatement(
            "insert into signup3 values (?, ?, ?, ?, ?)");
         PreparedStatement ps2 = c1.con.prepareStatement(
            "insert into login values (?,?,?)")) {

        ps1.setString(1, formno);
        ps1.setString(2, accountType);
        ps1.setString(3, cardnumber);
        ps1.setString(4, pinnumber);
        ps1.setString(5, facility.toString().trim());
        ps1.executeUpdate();

        ps2.setString(1, formno);
        ps2.setString(2, cardnumber);
        ps2.setString(3, pinnumber);
        ps2.executeUpdate();
    } finally {
        c1.con.close();
    }

    JOptionPane.showMessageDialog(null,
        "Card Number: " + cardnumber + "\nPin: " + pinnumber);
    setVisible(false);
    new Deposit(pinnumber).setVisible(true);

} catch (SQLException e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
}
    } else if (ae.getSource() == cancel) {
        setVisible(false);
        new Login().setVisible(true);
       // dispose();
    }
}
    public static void main(String[] args) {
        new Signupthree("");
    }
}
