package com.fotogram.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/fotogram";
        String user = "postgres";
        String pass = "buiminhtriet"; // buiminhtriet
        
        try {
            System.out.println("Connecting to DB: " + jdbcUrl);
            Connection conn = DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("Connection successful!");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }

}
