package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create a connection to the mysql database
            String url = "jdbc:mysql://localhost:3306/learnJDBC";
            String username = "root";
            String password = "password";

            Connection connection = DriverManager.getConnection(url, username, password);

            if (connection.isClosed()) {
                System.out.println("Connection is closed");
            } else {
                System.out.println("Connection created");

//                String query = """
//                        CREATE TABLE table1(
//                            tId INT(20) PRIMARY KEY AUTO_INCREMENT,
//                            tName VARCHAR(200) NOT NULL,
//                            tCity VARCHAR(200)
//                        )
//                        """;

                // Execute the query in the database
//                Statement statement = connection.createStatement();
//                statement.executeUpdate(query);
//
//                System.out.println("Table created in database...");

                String query = """
                        INSERT INTO table1(tName, tCity) VALUES (?, ?)
                        """;

                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, "Anupam Das");
                preparedStatement.setString(2, "Silchar");
                preparedStatement.executeUpdate();

                System.out.println("Values added successfully");

                connection.close();

            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}