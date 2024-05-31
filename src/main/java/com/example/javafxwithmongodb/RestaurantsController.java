package com.example.javafxwithmongodb;

import data.DBConnect;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import data.Restaurants;
import javafx.scene.control.cell.PropertyValueFactory;

public class RestaurantsController implements Initializable {

    @FXML
    public Label whichRestaurants;
    @FXML
    private TableView<Restaurants> restaurantsTableView;

    @FXML
    private TableColumn<Restaurants, String> nameColumn;
    @FXML
    private TableColumn<Restaurants, Integer> scoreColumn;
    @FXML
    private TableColumn<Restaurants, String> boroughColumn;
    @FXML
    private TableColumn<Restaurants, String> cuisineColumn;
    @FXML
    private TableColumn<Restaurants, String> streetColumn;
    @FXML
    private TableColumn<Restaurants, String> buildingColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        DBConnect connect = HelloApplication.getConnect();
        String borough = BoroughController.getBorough();
        String cuisine = CuisinesController.getCuisine();
        whichRestaurants.setText("Restaurants in " + borough + " with cuisine " + cuisine + ".");
        List<Restaurants> restaurants = connect.getRestaurants(borough,cuisine);

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));
        boroughColumn.setCellValueFactory(new PropertyValueFactory<>("borough"));
        cuisineColumn.setCellValueFactory(new PropertyValueFactory<>("cuisine"));
        streetColumn.setCellValueFactory(new PropertyValueFactory<>("street"));
        buildingColumn.setCellValueFactory(new PropertyValueFactory<>("building"));


        restaurantsTableView.setItems(FXCollections.observableArrayList(restaurants));


    }
}
