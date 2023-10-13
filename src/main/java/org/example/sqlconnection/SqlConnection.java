package org.example.sqlconnection;

import java.sql.*;
import static org.example.constants.User.*;

public class SqlConnection {

    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null) {
                // Load Driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Create a connection to the mysql database
                connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
