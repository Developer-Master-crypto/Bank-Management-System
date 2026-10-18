package org.ganesh;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;


public class PinChange extends JFrame implements ActionListener {
    ImageIcon i1, i3;
    Image i2;
    JLabel image,text,pintext, repintext;
    JPasswordField pinfield, repinfield;
    JButton change, back;
    String pinnumber;
    
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);

        i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(250, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new java.awt.Font("System",Font.BOLD,16));
        image.add(text);

        pintext = new JLabel("New PIN:");
        pintext.setBounds(165, 350, 180, 25);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new java.awt.Font("System",Font.BOLD,16));
        image.add(pintext);
        
        pinfield = new JPasswordField();
        pinfield.setBounds(330, 350, 180, 25);
        pinfield.setFont(new Font("System",Font.BOLD,16));
        image.add(pinfield);

        repintext = new JLabel("Re-Enter the PIN: ");
        repintext.setBounds(165, 400, 180, 25);
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System",Font.BOLD,16));
        image.add(repintext);

        repinfield = new JPasswordField();
        repinfield.setBounds(330, 400, 180, 25);
        repinfield.setFont(new Font("System",Font.BOLD,16));
        image.add(repinfield);

        change = new JButton("CHANGE");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        change.setBackground(Color.WHITE);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(170, 485, 150, 30);
        back.addActionListener(this);
        back.setBackground(Color.WHITE);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        

    }   

    public void actionPerformed(ActionEvent ae) {
        if(change == ae.getSource()){
            try{
                String npin = new String(pinfield.getPassword());
                String rpin = new String(repinfield.getPassword());
                
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter new PIN");
                    return;
                }

                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                    return;
                }

                if(!npin.matches("\\d{4}")){
                    JOptionPane.showMessageDialog(null, "PIN must be exactly 4 digits");
                    return;
                }

                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }

                connjdbc c = new connjdbc();
                
                String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                String query2 = "update login set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                String query3 = "update signup3 set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transaction(rpin).setVisible(true);

        }catch(Exception e){
            e.printStackTrace();
        }
        // setVisible(false);
        // new Transaction(pinnumber).setVisible(true);
    } else {
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }
    }
public static void main(String[] args) {
    new PinChange("").setVisible(true);
}
}

