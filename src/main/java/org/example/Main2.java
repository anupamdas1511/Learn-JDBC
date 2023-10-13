package org.example;

import org.example.sqlconnection.SqlConnection;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Main2 {
    public static void main(String[] args) {
        try {
            Connection con = SqlConnection.getConnection();

            String query = """
                    INSERT INTO images(pic) VALUES(?)
                    """;
            PreparedStatement preparedStatement = con.prepareStatement(query);

            JFileChooser jFileChooser = new JFileChooser();

            jFileChooser.showOpenDialog(null);

            File file = jFileChooser.getSelectedFile();
            FileInputStream fis = new FileInputStream(file);
            preparedStatement.setBinaryStream(1, fis, fis.available());
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "success");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
