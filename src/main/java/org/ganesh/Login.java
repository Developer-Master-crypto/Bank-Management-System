package org.ganesh;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame{

    Login() {
        setTitle("Automated Teller Machine");

        ImageIcon i1 = new ImageIcon(
                ClassLoader.getSystemResource("icons/logo.jpg")
        );

        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);

        ImageIcon i3 = new ImageIcon(i2);

        JLabel label = new JLabel(i3);

        label.setBounds(70,10,100,100);

        add(label);
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        JLabel cardno = new JLabel("Welcome to ATM");
        cardno.setFont(new Font("Osward",Font.BOLD,38));
        cardno.setBounds(200,0,400,40);
        add(cardno);
        JLabel pin = new JLabel("Welcome to ATM");
        pin.setFont(new Font("Osward",Font.BOLD,38));
        add(pin);
        getContentPane().setBackground(Color.WHITE);
        setSize(800,400);

        setLayout(null);

        setVisible(true);

        setLocation(350,200);

    }


    public static void main(String[] args) {
        new Login();
    }
}
