package com.example.projets7.controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.projets7.entity.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

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

    ObservableList<Product> lt = FXCollections.observableArrayList(
            new Clothes("Chaussette", 12.6, 0, 0, 35, 36),
            new Clothes("Clavier", 65.8, 0, 0, 12, 45)
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        name.setOnEditCommit(event ->  {
                Product p = event.getRowValue();
                p.setName(event.getNewValue());

        });
        price.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));
        price.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        price.setOnEditCommit(event ->  {
                Product p=event.getRowValue();
                p.setPrice(event.getNewValue());
        });
        nbItems.setCellValueFactory(new PropertyValueFactory<Product, Integer>("nbItems"));
        nbItems.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        nbItems.setOnEditCommit(event ->  {
                Product p = event.getRowValue();
                p.setNbItems(event.getNewValue());
        });

        Table.setItems(lt);
        Table.setItems(lt.filtered(Product ->
                Product.getName().toLowerCase().contains(search.getText().toLowerCase())
        ));
        search.textProperty().addListener((observable, oldValue, newValue) ->
                Table.setItems(lt.filtered(Product ->
                        Product.getName().toLowerCase().contains(newValue.toLowerCase())
                )));
        sizeitems.setText(lt.size() + " Items");
    }

    @FXML
    private Button add_accessory;

    @FXML
    private Button add_clothe;

    @FXML
    private Button add_shoe;

    @FXML
    private TextField aname;

    @FXML
    private TextField aprice;

    @FXML
    private TextField astock;

    @FXML
    private TextField mname;

    @FXML
    private TextField mprice;

    @FXML
    private Label sizeitems;

    @FXML
    private TextField mstock;

    @FXML
    private Button button_delete;

    @FXML
    private TextField cname;

    @FXML
    private TextField cprice;

    @FXML
    private TextField csize;

    @FXML
    private TextField cstock;
    @FXML
    private TextField sname;

    @FXML
    private TextField sprice;

    @FXML
    private TextField ssize;

    @FXML
    private TextField sstock;

    @FXML
    private TextField search;



    @FXML
    void AddClothe(ActionEvent event) throws IOException {
        Clothes c = new Clothes(cname.getText(), Double.parseDouble(cprice.getText()),
                0, 0, Integer.parseInt(cstock.getText()), Integer.parseInt(csize.getText()));
        lt.add(c);
        Table.setItems(lt);
        sizeitems.setText(lt.size() + " Items");
    }

    @FXML
    void AddShoe(ActionEvent event) throws IOException {
        Shoes s = new Shoes(sname.getText(), Double.parseDouble(sprice.getText()),
                0, 0, Integer.parseInt(sstock.getText()), Integer.parseInt(ssize.getText()));
        lt.add(s);
        Table.setItems(lt);
        sizeitems.setText(lt.size() + " Items");
    }

    @FXML
    void AddAccessory(ActionEvent event) throws IOException {
        Accessories a = new Accessories(aname.getText(), Double.parseDouble(aprice.getText()),
                0, 0, Integer.parseInt(astock.getText()));
        lt.add(a);
        //Table.setItems(lt);
        sizeitems.setText(lt.size() + " Items");
    }

    @FXML
    void OnDelete(ActionEvent event) {
        Product selected = Table.getSelectionModel().getSelectedItem();
        lt.remove(selected);
        sizeitems.setText(lt.size() + " Items");
    }





}
