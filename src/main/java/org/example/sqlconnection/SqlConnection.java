package org.example.sqlconnection;

import java.sql.*;
import static org.example.constants.User.*;

public class SqlConnection {

    private Connection connection;
    public SqlConnection() {
        try {
            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create a connection to the mysql database
            connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
