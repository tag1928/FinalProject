package com.example.finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;


public class RegistrationController {
    @FXML
    private Button login;
    @FXML
    private Button signup;



        @FXML
        private void SignUpButton(ActionEvent e) throws IOException {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("RegistrationPage.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage)((javafx.scene.Node)e.getSource()).getScene().getWindow();

            stage.setScene(new Scene(root));

        }
        @FXML
        private void LoginButton(ActionEvent e) throws IOException {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
                Parent root = loader.load();

                Stage stage = (Stage)((javafx.scene.Node)e.getSource()).getScene().getWindow();

                stage.setScene(new Scene(root));
                stage.show();
            }


}

