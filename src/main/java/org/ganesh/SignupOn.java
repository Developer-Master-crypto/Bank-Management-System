package org.ganesh;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.toedtor.calendar.JDateChooser;

public class SignupOn extends JFrame {

    JLabel formno,personDetails,name,fname,dob,gender,email,marital,city,Address,state,pincode;
    JTextField nameTextField,fnameTextField,emailTextField,dobTextField,genderTextField,maritalTextField,AddressTextField,cityTextField,stateTextField,pincodeTextField;

    SignupOn() {

        setLayout(null);

        Random ran = new Random();
        long random = Math.abs((ran.nextLong()%9000L)+1000L);

        formno = new JLabel("Application Form no: " + random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,50,600,40);
        add(formno);
        
        personDetails = new JLabel("Page 1: Personal Details");
        personDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personDetails.setBounds(290,100,400,40);
        add(personDetails);

        name = new JLabel("Name: ");
        name.setFont(new Font("Raleway",Font.BOLD,22));
        name.setBounds(100,150,100,30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300, 150, 400, 30);
        add(nameTextField);
         
        fname = new JLabel("Father's Name: ");
        fname.setFont(new Font("Raleway",Font.BOLD,22));
        fname.setBounds(100,200,200,30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(300, 200, 400, 30);
        add(fnameTextField);

        dob = new JLabel("Date of Birth: ");
        dob.setFont(new Font("Raleway",Font.BOLD,22));
        dob.setBounds(100,250,200,30);
        add(dob);

        JDateChooser datechooser = new JDateChooser();
        datechooser.setBounds(300,240,200,30);
        add(datechooser);


        gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway",Font.BOLD,22));
        gender.setBounds(100,300,100,30);
        add(gender);

        genderTextField = new JTextField();
        genderTextField.setFont(new Font("Raleway",Font.BOLD,14));
        genderTextField.setBounds(300,300,400,30);
        add(genderTextField);

        email = new JLabel("Email Address: ");
        email.setFont(new Font("Raleway",Font.BOLD,22));
        email.setBounds(100,350,200,30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300,350,400,30);
        add(emailTextField);
        
        marital = new JLabel("Marital status: ");
        marital.setFont(new Font("Raleway",Font.BOLD,22));
        marital.setBounds(100,400,200,30);
        add(marital);

        maritalTextField = new JTextField();
        maritalTextField.setFont(new Font("Raleway",Font.BOLD,14));
        maritalTextField.setBounds(300,400,400,30);
        add(maritalTextField);

        Address = new JLabel("Address: ");
        Address.setFont(new Font("Raleway",Font.BOLD,22));
        Address.setBounds(100,450,150,30);
        add(Address);

        AddressTextField = new JTextField();
        AddressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        AddressTextField.setBounds(300,450,400,30);
        add(AddressTextField);

        city = new JLabel("City: ");
        city.setFont(new Font("Raleway",Font.BOLD,22));
        city.setBounds(100,500,100,30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300,500,400,30);
        add(cityTextField);

        state = new JLabel("State: ");
        state.setFont(new Font("Raleway",Font.BOLD,22));
        state.setBounds(100,550,100,30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300,550,400,30);
        add(stateTextField);

        pincode = new JLabel("Pin Code: ");
        pincode.setFont(new Font("Raleway",Font.BOLD,22));
        pincode.setBounds(100,600,150,30);
        add(pincode);

        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pincodeTextField.setBounds(300,600,400,30);
        add(pincodeTextField);

        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);

    }
    
    public static void main(String[] args) {
        new SignupOn();
    }

}
