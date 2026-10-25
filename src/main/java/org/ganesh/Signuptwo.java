package org.ganesh;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Signuptwo extends JFrame implements ActionListener {

    JLabel formlabel, additionalDetails, religion, category, income, education,
           qualification, occupation, aadhaar, pan, senior, existing;
    JTextField panTextField, aadhaarTextField, incomeTextField;
    JRadioButton yes, no, eyes, eno;
    ButtonGroup existinggroup, seniorgroup;
    JButton next;
    JComboBox<String> religioncombobox, categorycombobox, educationalcomboBox, occupationcomboBox;
    String formno;

    Signuptwo(String formno) {
        this.formno = formno;

        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        formlabel = new JLabel("Application Form no: " + formno);
        formlabel.setFont(new Font("Raleway", Font.BOLD, 38));
        formlabel.setBounds(140, 50, 600, 40);
        add(formlabel);

        additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 100, 400, 40);
        add(additionalDetails);

        religion = new JLabel("Religion: ");
        religion.setFont(new Font("Raleway", Font.BOLD, 22));
        religion.setBounds(100, 150, 100, 30);
        add(religion);

        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religioncombobox = new JComboBox<>(valReligion);
        religioncombobox.setBounds(300, 150, 400, 30);
        religioncombobox.setBackground(Color.white);
        add(religioncombobox);

        category = new JLabel("Category: ");
        category.setFont(new Font("Raleway", Font.BOLD, 22));
        category.setBounds(100, 200, 200, 30);
        add(category);

        String valcategory[] = {"General", "OBC", "SC", "ST", "Other"};
        categorycombobox = new JComboBox<>(valcategory);
        categorycombobox.setBounds(300, 200, 400, 30);
        categorycombobox.setBackground(Color.white);
        add(categorycombobox);

        income = new JLabel("Income: ");
        income.setFont(new Font("Raleway", Font.BOLD, 22));
        income.setBounds(100, 250, 200, 30);
        add(income);

        incomeTextField = new JTextField();
        incomeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        incomeTextField.setBounds(300, 250, 400, 30);
        add(incomeTextField);

        education = new JLabel("Education");
        education.setFont(new Font("Raleway", Font.BOLD, 22));
        education.setBounds(100, 290, 300, 30);
        add(education);

        qualification = new JLabel("Qualification: ");
        qualification.setFont(new Font("Raleway", Font.BOLD, 22));
        qualification.setBounds(100, 315, 200, 30);
        add(qualification);

        String educationalvalues[] = {
            "Non-Graduation", "Graduate", "Post-Graduation", "Doctorate", "Others"
        };
        educationalcomboBox = new JComboBox<>(educationalvalues);
        educationalcomboBox.setBounds(300, 315, 400, 30);
        educationalcomboBox.setBackground(Color.white);
        add(educationalcomboBox);

        occupation = new JLabel("Occupation: ");
        occupation.setFont(new Font("Raleway", Font.BOLD, 22));
        occupation.setBounds(100, 400, 200, 30);
        add(occupation);

        String occupationvalues[] = {
            "Salaried", "Self-Employed", "Business", "Student", "Retired", "Other"
        };
        occupationcomboBox = new JComboBox<>(occupationvalues);
        occupationcomboBox.setBounds(300, 400, 400, 30);
        occupationcomboBox.setBackground(Color.white);
        add(occupationcomboBox);

        pan = new JLabel("Pan Number: ");
        pan.setFont(new Font("Raleway", Font.BOLD, 22));
        pan.setBounds(100, 450, 200, 30);
        add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300, 450, 400, 30);
        add(panTextField);

        aadhaar = new JLabel("Aadhaar Number: ");
        aadhaar.setFont(new Font("Raleway", Font.BOLD, 22));
        aadhaar.setBounds(100, 500, 200, 30);
        add(aadhaar);

        aadhaarTextField = new JTextField();
        aadhaarTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhaarTextField.setBounds(300, 500, 400, 30);
        add(aadhaarTextField);

        senior = new JLabel("Senior Citizen: ");
        senior.setFont(new Font("Raleway", Font.BOLD, 22));
        senior.setBounds(100, 550, 200, 30);
        add(senior);

        yes = new JRadioButton("Yes");
        yes.setBounds(300, 550, 100, 30);
        yes.setBackground(Color.WHITE);
        add(yes);

        no = new JRadioButton("No");
        no.setBounds(400, 550, 100, 30);
        no.setBackground(Color.WHITE);
        add(no);

        seniorgroup = new ButtonGroup();
        seniorgroup.add(yes);
        seniorgroup.add(no);

        existing = new JLabel("Existing Customer: ");
        existing.setFont(new Font("Raleway", Font.BOLD, 22));
        existing.setBounds(90, 600, 300, 30);
        add(existing);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 600, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(400, 600, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        existinggroup = new ButtonGroup();
        existinggroup.add(eyes);
        existinggroup.add(eno);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 650, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String religionValue  = (String) religioncombobox.getSelectedItem();
        String categoryValue  = (String) categorycombobox.getSelectedItem();
        String incomeValue    = incomeTextField.getText().trim();
        String educationValue = (String) educationalcomboBox.getSelectedItem();
        String occupationValue= (String) occupationcomboBox.getSelectedItem();
        String panValue       = panTextField.getText().trim();
        String aadhaarValue   = aadhaarTextField.getText().trim();

        // ---------- VALIDATION ----------

        if (incomeValue.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter your income");
            return;
        }
        try {
            Long.parseLong(incomeValue);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Income must contain only numbers");
            return;
        }

        if (panValue.isEmpty()) {
            JOptionPane.showMessageDialog(null, "PAN Number is required");
            return;
        }

        // Fix: PAN format validation (Indian PAN: 5 letters, 4 digits, 1 letter)
        if (!panValue.matches("[A-Z]{5}[0-9]{4}[A-Z]")) {
            JOptionPane.showMessageDialog(null, "PAN Number must be in format: ABCDE1234F");
            return;
        }

        if (aadhaarValue.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Aadhaar Number is required");
            return;
        }

        if (!aadhaarValue.matches("\\d{12}")) {
            JOptionPane.showMessageDialog(null, "Aadhaar Number must contain exactly 12 digits");
            return;
        }

        String seniorCitizen = null;
        if (yes.isSelected()) {
            seniorCitizen = "Yes";
        } else if (no.isSelected()) {
            seniorCitizen = "No";
        }

        if (seniorCitizen == null) {
            JOptionPane.showMessageDialog(null, "Please select Senior Citizen status");
            return;
        }

        String existingCustomer = null;
        if (eyes.isSelected()) {
            existingCustomer = "Yes";
        } else if (eno.isSelected()) {
            existingCustomer = "No";
        }

        if (existingCustomer == null) {
            JOptionPane.showMessageDialog(null, "Please select Existing Customer status");
            return;
        }

        // ---------- DATABASE (Fix: use PreparedStatement to prevent SQL injection) ----------
        try {
            connjdbc c = new connjdbc();
            try (PreparedStatement ps = c.con.prepareStatement(
                    "INSERT INTO signup2 VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
                ps.setString(1, formno);
                ps.setString(2, religionValue);
                ps.setString(3, categoryValue);
                ps.setString(4, incomeValue);
                ps.setString(5, educationValue);
                ps.setString(6, occupationValue);
                ps.setString(7, panValue);
                ps.setString(8, aadhaarValue);
                ps.setString(9, seniorCitizen);
                ps.setString(10, existingCustomer);
                ps.executeUpdate();
            } finally {
                try { c.con.close(); } catch (Exception ignored) {}
            }

            JOptionPane.showMessageDialog(null, "Details saved successfully");
            setVisible(false);
            new Signupthree(formno).setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Signuptwo("").setVisible(true);
    }
}
