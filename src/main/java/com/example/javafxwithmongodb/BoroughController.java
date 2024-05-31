package com.example.javafxwithmongodb;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import data.DBConnect;
import javafx.scene.control.Label;

// написать получение того что выбрал пользователь
public class BoroughController implements Initializable {
    @FXML
    public Label alertText;
    private static String borough;

    @FXML
    public ComboBox<String> comboBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        DBConnect connect = HelloApplication.getConnect();
        comboBox.setItems(FXCollections.observableArrayList(connect.getBoroughs()));
    }

    @FXML
    public void getComboBoxInfo(){
        borough = comboBox.getValue();
    }

    @FXML
    void nextCuisines() throws IOException {
        if (borough != null && !borough.isEmpty()){
            HelloApplication.changeScene("cuisines.fxml");
        }else {
            alertText.setText("Сhoose and submit borough!");
        }
    }

    public static String getBorough(){
        return borough;
    }

}
