package com.example.projets7;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloControllerAdam implements Initializable {

    @FXML
    private TableColumn<Product, Integer> id;

    @FXML
    private TableColumn<Product, String> name;

    @FXML
    private TableColumn<Product, Double> price;

    @FXML
    private TableColumn<Product, Integer> nbItems;

    @FXML
    private TableView<Product> Table;

    ObservableList<Product> lt= FXCollections.observableArrayList(
            new Clothes("Chaussette", 12.6, 35, 36),
            new Clothes("Clavier", 65.8, 12, 45)
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        id.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        price.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));
        nbItems.setCellValueFactory(new PropertyValueFactory<Product, Integer>("nbItems"));
        Table.setItems(lt);
        Table.setItems(lt.filtered(Product ->
                Product.getName().toLowerCase().contains(search.getText().toLowerCase())
        ));
        search.textProperty().addListener((observable, oldValue, newValue) ->
                Table.setItems(lt.filtered(Product ->
                        Product.getName().toLowerCase().contains(newValue.toLowerCase())
                )));
    }
    @FXML
    private Button button_add;


    @FXML
    private Button button_delete;

    @FXML
    private Button button_search;

    @FXML
    private TextField search;
    @FXML
    private TextField tfname;

    @FXML
    private TextField tfprice;

    @FXML
    private TextField tfsize;

    @FXML
    private TextField tfstock;

    @FXML
    private Label ws;

    @FXML
    void OnAdd(ActionEvent event) throws IOException {
        Clothes t = new Clothes(tfname.getText(),Double.parseDouble(tfprice.getText()),
                Integer.parseInt(tfstock.getText()),Integer.parseInt(tfsize.getText()));
        lt.add(t);
        Table.setItems(lt);
    }

    @FXML
    void OnDelete(ActionEvent event) {
        Product selected=Table.getSelectionModel().getSelectedItem();
        lt.remove(selected);
    }

    @FXML
    void OnSearch(ActionEvent event) {

    }

}
