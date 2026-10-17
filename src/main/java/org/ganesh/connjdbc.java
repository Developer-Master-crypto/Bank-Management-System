package org.ganesh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class connjdbc {
    Connection con;
    Statement s;

    public connjdbc() throws SQLException {
        try{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL driver not found. Add mysql-connector-j to your build path.", e);
        }
        con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/bankmanagementsystem", "VEIT", "Password@28.");
        s = con.createStatement();
        } catch (SQLException e) {
            throw new SQLException("Failed to connect to the database. Check your connection parameters.", e);
            //throw new SQLException("An unexpected error occurred while connecting to the database.", e);
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("An unexpected error occurred while connecting to the database.", e);
        }
    }

}