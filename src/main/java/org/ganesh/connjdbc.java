package org.ganesh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class connjdbc {
Connection con;
Statement s;
    public connjdbc() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem","VEIT","Password@28.");
            s = con.createStatement();
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
public static void main(String[] args) {
    
}
}
