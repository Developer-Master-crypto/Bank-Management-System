package org.ganesh;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class Signuptwo extends JFrame implements ActionListener {

    JLabel formno,additionalDetails,name,fname,dob,gender,email,marital,city,Address,state,pincode;
    JTextField nameTextField,fnameTextField,emailTextField,AddressTextField,cityTextField,stateTextField,pincodeTextField;
    JRadioButton male,female,other,Marital,single;
    ButtonGroup genderGroup,maritalGroup;
    JButton next;
    long random;
    Random ran;
    JDateChooser dateChooser;

    Signuptwo() {
        
        ran = new Random();
        setLayout(null);
        random = Math.abs((ran.nextLong()%9000L)+1000L);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        formno = new JLabel("Application Form no: " + random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,50,600,40);
        add(formno);
        
        additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,100,400,40);
        add(additionalDetails);

        name = new JLabel("Religion: ");
        name.setFont(new Font("Raleway",Font.BOLD,22));
        name.setBounds(100,150,100,30);
        add(name);

        String valReligion[] = {"Hindu","Muslim","sikh","Christian","Other"};
        JComboBox religion = new JComboBox(valReligion);
        religion.setBounds(300,150,400,30);
        religion.setBackground(Color.white);
        add(religion);
         
       
        fname = new JLabel("Category: ");
        fname.setFont(new Font("Raleway",Font.BOLD,22));
        fname.setBounds(100,200,200,30);
        add(fname);

         String valcategory[] = {"General","OBC","SC","SI","Other"};
         JComboBox category = new JComboBox<>(valcategory);
        category.setBounds(300, 200, 400, 30);
        category.setBackground(Color.white);
        add(category);

        dob = new JLabel("Income: ");
        dob.setFont(new Font("Raleway",Font.BOLD,22));
        dob.setBounds(100,250,200,30);
        add(dob);

        String incomecategory[] = {"Null","< 1,50,000","< 2,50,000","< 5,00,000","< 10,00,000"};
        JComboBox income = new JComboBox(incomecategory);
        income.setBounds(300, 250, 400, 30);
        income.setBackground(Color.white);
        add(income);

        // dateChooser = new JDateChooser();
        // dateChooser.setDateFormatString("dd-MM-yyyy");
        // dateChooser.setDate(null); // Starts blank instead of today's date
        // dateChooser.setBounds(300, 250, 400, 30);
        // dateChooser.setFont(new Font("Raleway", Font.BOLD, 14));
        // dateChooser.setForeground(Color.GREEN);
        // add(dateChooser);

        gender = new JLabel("Education ");
        gender.setFont(new Font("Raleway",Font.BOLD,22));
        gender.setBounds(100,290,300,30);
        add(gender);

        // genderTextField = new JTextField();
        // genderTextField.setFont(new Font("Raleway",Font.BOLD,14));
        // genderTextField.setBounds(300,300,400,30);
        // add(genderTextField);

        // male = new JRadioButton("Male");
        // male.setBounds(300, 300, 60, 30);
        // male.setBackground(Color.white);
        // add(male);

        // female = new JRadioButton("Female");
        // female.setBounds(450, 300, 100, 30);
        // female.setBackground(Color.WHITE);
        // add(female);

        // other = new JRadioButton("Other");
        // other.setBounds(600, 300, 100, 30);
        // other.setBackground(Color.WHITE);
        // add(other);

        // genderGroup = new ButtonGroup();
        // genderGroup.add(male);
        // genderGroup.add(female);
        // genderGroup.add(other);

        email = new JLabel("Qualification: ");
        email.setFont(new Font("Raleway",Font.BOLD,22));
        email.setBounds(100,315,200,30);
        add(email);

        String educationalvalues[] = {
            "Non-Graduation",
            "Graduate",
            "PostGraduation",
            "Doctrate",
            "Others"
        };
        JComboBox<String> educationalcomboBox = new JComboBox<>(educationalvalues);
        educationalcomboBox.setBounds(300, 315, 400, 30);
        educationalcomboBox.setBackground(Color.white);
        add(educationalcomboBox);

        // emailTextField = new JTextField();
        // emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        // emailTextField.setBounds(300,350,400,30);
        // add(emailTextField);
        
        marital = new JLabel("Occupation: ");
        marital.setFont(new Font("Raleway",Font.BOLD,22));
        marital.setBounds(100,400,200,30);
        add(marital);

        String occupationvalues[] = {
            "Salaried",
            "Self-Employed",
            "Business",
            "student",
            "Retired",
            "Other"
        };
        JComboBox<String> occupationcomboBox = new JComboBox<>(occupationvalues);
        occupationcomboBox.setBounds(300, 400, 400, 30);
        occupationcomboBox.setBackground(Color.white);
        add(occupationcomboBox);

        // maritalTextField = new JTextField();
        // maritalTextField.setFont(new Font("Raleway",Font.BOLD,14));
        // maritalTextField.setBounds(300,400,400,30);
        // add(maritalTextField);

        // Marital = new JRadioButton("Married");
        // Marital.setBounds(300, 400, 100, 30);
        // Marital.setBackground(Color.WHITE);
        // add(Marital);

        // single = new JRadioButton("Single");
        // single.setBounds(450, 400, 100, 30);
        // single.setBackground(Color.WHITE);
        // add(single);

        // maritalGroup = new ButtonGroup();
        // maritalGroup.add(Marital);
        // maritalGroup.add(single);

        Address = new JLabel("Pan Number: ");
        Address.setFont(new Font("Raleway",Font.BOLD,22));
        Address.setBounds(100,450,200,30);
        add(Address);

        AddressTextField = new JTextField();
        AddressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        AddressTextField.setBounds(300,450,400,30);
        add(AddressTextField);

        city = new JLabel("Aadhaar Number: ");
        city.setFont(new Font("Raleway",Font.BOLD,22));
        city.setBounds(100,500,200,30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300,500,400,30);
        add(cityTextField);

        state = new JLabel("Senior Citizen: ");
        state.setFont(new Font("Raleway",Font.BOLD,22));
        state.setBounds(100,550,200,30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300,550,400,30);
        add(stateTextField);

        pincode = new JLabel("Existing Customer: ");
        pincode.setFont(new Font("Raleway",Font.BOLD,22));
        pincode.setBounds(90,600,300,30);
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
    
    
    @Override
    public void actionPerformed(ActionEvent ae){
        String formno = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
            if (male.isSelected()) {
        gender = "Male";
    } else if (female.isSelected()) {
        gender = "Female";
    } else if (other.isSelected()) {
        gender = "Other";
    }

    String email = emailTextField.getText();
    String marital = null;
    if (Marital.isSelected()) {
        marital = "Married";
    } else if (single.isSelected()) {
        marital = "Single";
    }

    String address = AddressTextField.getText();
    String city = cityTextField.getText();
    String state = stateTextField.getText();
    String pincode = pincodeTextField.getText();

    try {
        if (name.equals("")) {
            JOptionPane.showMessageDialog(null, "Name is required");
        } else {
            connjdbc c = new connjdbc();
            String query = "insert into signup vajlues('" + formno + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','" + marital + "','" + address + "','" + city + "','" + state + "','" + pincode + "')";
            c.s.executeUpdate(query);

            // setVisible(false);
            // new SignupTwo(formno).setVisible(true);
        }
    } catch (Exception e) {
        System.out.println(e);
    }
}

public static void main(String[] args) {
        new Signuptwo();
    }

}

