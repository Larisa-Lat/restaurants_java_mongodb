package com.example.javafxwithmongodb;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import data.DBConnect;
import java.io.IOException;

public class HelloApplication extends Application {
    private static Stage stage;
    private static Scene scene;
    private static Parent root;
    private static DBConnect connect;

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        this.root = root;
        this.stage = stage;
        this.connect = new DBConnect();
    }

    public static void changeScene(String fxml) throws IOException {
        root = FXMLLoader.load(HelloApplication.class.getResource(fxml));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static DBConnect getConnect(){
        return connect;
    }
    public static void closeConnect(){
        connect.closeDbConnect();
    }



    public static void main(String[] args) {
        launch();
    }
}