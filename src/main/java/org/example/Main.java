package org.example;

import org.example.sqlconnection.SqlConnection;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.*;
//import org.example.images.*;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = SqlConnection.getConnection();

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

//                String query = """
//                        INSERT INTO table1(tName, tCity) VALUES (?, ?)
//                        """;
//
//                PreparedStatement preparedStatement = connection.prepareStatement(query);
//
//                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//                System.out.print("Enter how many values you want to enter: ");
//                int n = Integer.parseInt(reader.readLine());
//                while (n-->0) {
//                    System.out.print("Enter name: ");
//                    String name = reader.readLine();
//                    System.out.print("Enter city: ");
//                    String city = reader.readLine();
//
//                    preparedStatement.setString(1, name);
//                    preparedStatement.setString(2, city);
//                    preparedStatement.executeUpdate();
//                }


                // ! Insert images

                String query = """
                        INSERT INTO images(pic) VALUES(?)
                        """;
                PreparedStatement preparedStatement = connection.prepareStatement(query);

                FileInputStream file = new FileInputStream("src/main/java/org/example/images/durga-puja.jpg");
                preparedStatement.setBinaryStream(1, file, file.available());
                preparedStatement.executeUpdate();

                System.out.println("Values added successfully");

                connection.close();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}