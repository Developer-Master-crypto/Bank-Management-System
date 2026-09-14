package org.ganesh;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

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

        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Osward",Font.BOLD,38));
        cardno.setBounds(120,150,150,30);
        add(cardno);

        JTextField cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 250, 30);
        add(cardTextField);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Osward",Font.BOLD,38));
        pin.setBounds(150,220,250,30);
        add(pin);

        JTextField pinTextField = new JTextField();
        pinTextField.setBounds(300, 220, 250, 30);
        add(pinTextField);

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
