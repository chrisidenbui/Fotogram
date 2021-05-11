package com.fotogram.hibernate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/fotogram";
        String user = "postgres";
        String pass = "!QAZ2wsx";
        
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
