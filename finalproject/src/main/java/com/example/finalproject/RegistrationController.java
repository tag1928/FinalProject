package com.example.finalproject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrationController {
    @FXML
    private Button ReturnTMP;
    @FXML
    private Button CreateAcc;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField mail;
    @FXML
    private TextField phonenumber;

    public static int userId;

    @FXML
    public static Connection connect() throws SQLException
    {
        String url = "jdbc:mysql://localhost:3306/real_facebook";
        String user = "root";
        String password = "password";
        return DriverManager.getConnection(url, user, password);
    }

    @FXML
    private void CreateAccount(ActionEvent event) throws Exception
    {
        String name = username.getText();
        String email = mail.getText();
        String Phonenumber = phonenumber.getText();
        String Pass = password.getText();
        String friends = name + "Friends.txt";

        String sql = "INSERT INTO users (name, email, phoneNumber, password, friends) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, Phonenumber);
            pstmt.setString(4, Pass);
            pstmt.setString(5, friends);
            pstmt.executeUpdate();

            PreparedStatement pt = conn.prepareStatement("SELECT * FROM users WHERE email = ?;");
            pt.setString(1, email);

            ResultSet a = pt.executeQuery();

            userId = a.getInt("ID");
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        ReturnToMainPage(event);
    }
    @FXML
    public void ReturnToMainPage(ActionEvent e) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage)((javafx.scene.Node)e.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.show();

    }
}
