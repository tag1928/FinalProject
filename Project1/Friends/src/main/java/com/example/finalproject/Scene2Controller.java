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

public class Scene2Controller
{
    @FXML
    private Button loginbutt;
    @FXML
    private TextField UsernameOrMail;
    @FXML
    private PasswordField Password;


    public void Login(ActionEvent e) throws Exception
    {
        ;
    }

    public void ReturnToMainPage(javafx.event.ActionEvent e) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RegistrationPage.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage)((javafx.scene.Node)e.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.show();

    }
}
