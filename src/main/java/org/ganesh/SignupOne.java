package org.ganesh;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

@SuppressWarnings ("serial")
public class SignupOne extends JFrame implements ActionListener {

    JLabel formno,personDetails,name,fname,dob,gender,email,marital,city,Address,state,pincode;
    JTextField nameTextField,fnameTextField,emailTextField,AddressTextField,cityTextField,stateTextField,pincodeTextField;
    JRadioButton male,female,other,Marital,single;
    ButtonGroup genderGroup,maritalGroup;
    JButton next;
    long random;
    Random ran;
    JDateChooser dateChooser;

    SignupOne() {
        
        ran = new Random();
        setLayout(null);
        random = Math.abs(ran.nextLong() % 9000L) + 1000L;

        setTitle("NEW ACCOUNT APPLICATION FORM");

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

        dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("dd-MM-yyyy");
        dateChooser.setDate(null); // Starts blank instead of today's date
        dateChooser.setBounds(300, 250, 400, 30);
        dateChooser.setFont(new Font("Raleway", Font.BOLD, 14));
        dateChooser.setForeground(Color.GREEN);
        add(dateChooser);

        gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway",Font.BOLD,22));
        gender.setBounds(100,300,100,30);
        add(gender);

        // genderTextField = new JTextField();
        // genderTextField.setFont(new Font("Raleway",Font.BOLD,14));
        // genderTextField.setBounds(300,300,400,30);
        // add(genderTextField);

        male = new JRadioButton("Male");
        male.setBounds(300, 300, 60, 30);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450, 300, 100, 30);
        female.setBackground(Color.WHITE);
        add(female);

        other = new JRadioButton("Other");
        other.setBounds(600, 300, 100, 30);
        other.setBackground(Color.WHITE);
        add(other);

        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);

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

        // maritalTextField = new JTextField();
        // maritalTextField.setFont(new Font("Raleway",Font.BOLD,14));
        // maritalTextField.setBounds(300,400,400,30);
        // add(maritalTextField);

        Marital = new JRadioButton("Married");
        Marital.setBounds(300, 400, 100, 30);
        Marital.setBackground(Color.WHITE);
        add(Marital);

        single = new JRadioButton("Single");
        single.setBounds(450, 400, 100, 30);
        single.setBackground(Color.WHITE);
        add(single);

        maritalGroup = new ButtonGroup();
        maritalGroup.add(Marital);
        maritalGroup.add(single);

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

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620, 650, 80, 30);
        next.addActionListener(this); 
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);

    }
    
    public static void main(String[] args) {
        new SignupOne();
    }
    
@Override
public void actionPerformed(ActionEvent ae) {

    String formno = "" + random;

    // Get values from text fields
    String name = nameTextField.getText().trim();
    String fname = fnameTextField.getText().trim();

    if (dateChooser.getDate() == null) {
        JOptionPane.showMessageDialog(null, "Date of birth is required");
        return;
    }
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy");

    String dob = sdf.format(dateChooser.getDate());

    String email = emailTextField.getText().trim();
    String address = AddressTextField.getText().trim();
    String city = cityTextField.getText().trim();
    String state = stateTextField.getText().trim();
    String pincode = pincodeTextField.getText().trim();

    // Gender
    String gender = null;

    if (male.isSelected()) {
        gender = "Male";
    } else if (female.isSelected()) {
        gender = "Female";
    } else if (other.isSelected()) {
        gender = "Other";
    }

    // Marital Status
    String marital = null;

    if (Marital.isSelected()) {
        marital = "Married";
    } else if (single.isSelected()) {
        marital = "Single";
    }

    try {

        // ---------------- VALIDATION ----------------

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Name is required"
            );
            return;
        }

        if (fname.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Father's name is required"
            );
            return;
        }

        if (dob.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Date of birth is required"
            );
            return;
        }

        if (gender == null) {
            JOptionPane.showMessageDialog(
                    null,
                    "Please select gender"
            );
            return;
        }

        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Email is required"
            );
            return;
        }

        // Simple email validation
        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
    JOptionPane.showMessageDialog(
        null,
        "Please enter a valid email address"
    );
    return;
}

        if (marital == null) {
            JOptionPane.showMessageDialog(
                    null,
                    "Please select marital status"
            );
            return;
        }

        if (address.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Address is required"
            );
            return;
        }

        if (city.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "City is required"
            );
            return;
        }

        if (state.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "State is required"
            );
            return;
        }

        if (pincode.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Pincode is required"
            );
            return;
        }

        // Indian 6-digit pincode validation
        if (!pincode.matches("\\d{6}")) {
    JOptionPane.showMessageDialog(
        null,
        "Pincode must contain exactly 6 digits"
    );
    return;
}

        // ---------------- DATABASE ----------------

        connjdbc c = new connjdbc();

        String query = "INSERT INTO signupOne "
                + "(formno, name, fname, dob, gender, email, marital, "
                + "address, city, state, pincode) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = c.con.prepareStatement(query)) {
            ps.setString(1, formno);
            ps.setString(2, name);
            ps.setString(3, fname);
            ps.setString(4, dob);
            ps.setString(5, gender);
            ps.setString(6, email);
            ps.setString(7, marital);
            ps.setString(8, address);
            ps.setString(9, city);
            ps.setString(10, state);
            ps.setString(11, pincode);
            ps.executeUpdate();
            // ---------------- SUCCESS ----------------
            JOptionPane.showMessageDialog(
                    null,
                    "Form submitted successfully!\nForm Number: " + formno
            );
            // Move to next form if required
            // setVisible(false);
            // new SignupTwo(formno).setVisible(true);
            // Close PreparedStatement
        }
        c.con.close();
        setVisible(false);
        new Signuptwo(formno).setVisible(true);

    } catch (Exception e) {

        e.printStackTrace();

        JOptionPane.showMessageDialog(
                null,
                "Database Error: " + e.getMessage()
        );
    }
}
}
