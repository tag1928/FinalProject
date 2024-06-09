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
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

public class profileController
{
    @FXML
    private Label Status;
    @FXML
    private Label Username;

    @FXML
    private TextField imageAddress;
    @FXML
    private TextField StatusText;
    @FXML
    private TextField friendName;

    @FXML
    private ImageView profilePic;

    @FXML
    private Button setPicture;
    @FXML
    private Button setStatus;
    @FXML
    private Button Logoutbutton;
    @FXML
    private Button addFriendButton;
    @FXML
    private Button delFriendButton;

    private String url = "jdbc:mysql://localhost:3306/real_facebook";
    private String name = "root";
    private String password = "donpollo";

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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage)((javafx.scene.Node)e.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.show();
    }

    public void addFriend() throws Exception
    {
        Connection connection = DriverManager.getConnection(url, name, password);

    }

    public void delFriend() throws Exception
    {
        ;
    }
}
