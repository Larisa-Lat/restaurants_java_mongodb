package com.example.javafxwithmongodb;

import data.DBConnect;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class CuisinesController implements Initializable {
    @FXML
    public Label alertText;
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
        }else {
            alertText.setText("Сhoose and submit cuisine!");
        }
    }
    public static String getCuisine(){
        return cuisine;
    }

}
