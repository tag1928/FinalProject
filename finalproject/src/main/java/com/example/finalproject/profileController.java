package com.example.finalproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class profileController {
    @FXML
    private Label Status;
    @FXML
    private Label Username;

    @FXML
    private TextField imageAddress;
    @FXML
    private TextField StatusText;
    @FXML
    private TextField friendNameText;

    @FXML
    private ImageView profilePic;

    @FXML
    private Button setPicture;
    @FXML
    private Button setStatus;
    @FXML
    private Button Logoutbutton;

    @FXML
    public void setpic()
    {
        setPicture.setOnAction(e -> setProfilePicture());
    }

    private void setProfilePicture()
    {
        String imageUrl = imageAddress.getText();
        Image image = new Image(imageUrl);
        profilePic.setImage(image);
    }

    @FXML
    public void ButtonSetStatus()
    {
        setStatus.setOnAction(e -> setStatuscode());
    }

    private void setStatuscode()
    {
        String text = StatusText.getText();
        Status.setText(text);
    }

    @FXML
    private void logoutcode(ActionEvent e) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage)((javafx.scene.Node)e.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void addFriend(javafx.event.ActionEvent e) throws Exception
    {
        try(Connection connection = RegistrationController.connect())
        {
            PreparedStatement pt = connection.prepareStatement("SELECT WHERE ID = ? FROM users;");
            pt.setInt(1, RegistrationController.userId);

            ResultSet a = pt.executeQuery();

            BufferedWriter writer = new BufferedWriter(new FileWriter(a.getString("friends")));
            writer.write(friendNameText.getText() + "\n");
        }

        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
