package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/learnJDBC";
            String username = "root";
            String password = "password";

            Connection connection = DriverManager.getConnection(url, username, password);

            if (connection.isClosed()) {
                System.out.println("Connection is closed");
            } else {
                System.out.println("Connection created");
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}