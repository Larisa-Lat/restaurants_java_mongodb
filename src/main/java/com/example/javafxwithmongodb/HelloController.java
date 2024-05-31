package com.example.javafxwithmongodb;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    void onHelloButtonClick() throws IOException {
//        welcomeText.setText("Welcome to JavaFX Application !");
        HelloApplication.changeScene("boroughs.fxml");
    }

}