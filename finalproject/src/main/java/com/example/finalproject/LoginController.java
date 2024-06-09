package com.example.finalproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class LoginController {
    @FXML
    private Button loginButton;
    @FXML
    private TextField UsernameOrMail;
    @FXML
    private PasswordField Password;


    public void Login(javafx.event.ActionEvent e) throws Exception
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("profile.fxml"));
        Scene root = loader.load();

        Stage stage = (Stage)((javafx.scene.Node)e.getSource()).getScene().getWindow();

        stage.setScene(root);
        stage.show();
    }
}
