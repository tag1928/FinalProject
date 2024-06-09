package com.example.finalproject;

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

public class Scene1Controller {
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



    @FXML
    private Connection connect() throws SQLException {

        String url = "jdbc:mysql://localhost:3306/real_facebook";
        String user = "root";
        String password = "password";
        return DriverManager.getConnection(url, user, password);
    }

    @FXML
    private void CreateAccount(ActionEvent event) {
        String name = username.getText();
        String email = mail.getText();
        String Phonenumber = phonenumber.getText();
        String Pass = password.getText();

        String sql = "INSERT INTO users (password,username,phone_number,email) VALUES (?,?,?,?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, Pass);
            pstmt.setString(2, name);
            pstmt.setString(3, Phonenumber);
            pstmt.setString(4, email);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    @FXML
    public void ReturnToMainPage(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RegistrationPage.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage)((javafx.scene.Node)e.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.show();

    }
}
