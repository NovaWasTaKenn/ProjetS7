package com.example.projets7.controller;

import com.example.projets7.entity.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class stockController implements Initializable {

    @FXML
    private ListView stockLV;
    private ObservableList<Product> items;


    @FXML
    protected void onTestButtoClicked() throws IOException {
        stockLV.getItems().add("Item 4");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> items = FXCollections.observableArrayList("Item 1", "Item 2", "Item 3");
        stockLV.setItems(items);
        stockLV.setEditable(true);
    }
}
