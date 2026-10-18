package org.ganesh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class connjdbc {
    Connection con;
    Statement s;

    public connjdbc() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bankmanagementsystem", "VEIT", "Password@28.");
            s = con.createStatement();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL driver not found. Add mysql-connector-j to your build path.", e);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to connect to the database. Check that MySQL is running and the credentials are correct.", e);
        }
    }
}
