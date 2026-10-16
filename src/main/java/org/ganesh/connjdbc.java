package org.ganesh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class connjdbc {
    Connection con;
    Statement s;

    public connjdbc() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL driver not found. Add mysql-connector-j to your build path.", e);
        }
        con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/bankmanagementsystem", "VEIT", "Password@28.");
        s = con.createStatement();
    }
}