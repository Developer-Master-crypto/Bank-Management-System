package org.ganesh;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import javax.swing.*;

public class SignupOn extends JFrame {

    SignupOne() {

        setLayout(null);

        Random ran = new Random();
        long random = Math.abs((ran.nextLong()%9000L)+1000L);

        JLabel formno = new JLabel("Application Form no: " + random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);

        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);

    }
    
    public static void main(String[] args) {
        new SignupOne();
    }

}
