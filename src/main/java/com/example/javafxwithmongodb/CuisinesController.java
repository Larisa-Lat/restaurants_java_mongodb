package com.example.javafxwithmongodb;

import data.DBConnect;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class CuisinesController implements Initializable {
    private static String cuisine;

    @FXML
    public ComboBox<String> comboBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        DBConnect connect = HelloApplication.getConnect();
        String borough = BoroughController.getBorough();
        comboBox.setItems(FXCollections.observableArrayList(connect.getCuisine(borough)));
    }

    @FXML
    public void getComboBoxInfo(){
        cuisine = comboBox.getValue();
    }

    @FXML
    void nextRestaurants() throws IOException {
        if (cuisine != null && !cuisine.isEmpty()){
            HelloApplication.changeScene("restaurants.fxml");
        }
    }
    public static String getCuisine(){
        return cuisine;
    }

}
