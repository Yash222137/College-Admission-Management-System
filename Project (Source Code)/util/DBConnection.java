package com.college.admission.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // Database credentials - Change these as per your local setup
    private static final String URL = "jdbc:mysql://localhost:3306/college_admission_db";
    private static final String USER = "root";
    private static final String PASSWORD = "63929240";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL Driver not found! Include the JDBC driver in your classpath.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Connection Failed! Check output console");
            e.printStackTrace();
        }
        return conn;
    }
}
