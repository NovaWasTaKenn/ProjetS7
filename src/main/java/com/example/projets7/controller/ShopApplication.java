package com.example.projets7.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ShopApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ShopApplication.class.getResource("/com/example/projets7/hello-viewadam.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("WorkShop");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}