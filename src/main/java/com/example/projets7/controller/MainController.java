package com.example.projets7.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class MainController {

    @FXML
    private AnchorPane rightAnchorPane;

    @FXML
    private HBox hbox;

    @FXML
    protected void onCompanyButtonClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("stockList.fxml"));
        rightAnchorPane = loader.load();

        // assuming the existing pane is the second one in the split pane:
        hbox.getChildren().add(rightAnchorPane) ;
    }

    @FXML
    protected void onProductsButtonClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ListOfPatients.fxml"));
        rightAnchorPane = loader.load();

        // assuming the existing pane is the second one in the split pane:
        hbox.getChildren().add(rightAnchorPane) ;
    }

    @FXML
    protected void onStockButtonClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ListOfPatients.fxml"));
        rightAnchorPane = loader.load();

        // assuming the existing pane is the second one in the split pane:
        hbox.getChildren().add(rightAnchorPane) ;
    }


}