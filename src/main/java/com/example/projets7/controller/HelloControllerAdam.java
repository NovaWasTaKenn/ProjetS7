package com.example.projets7.controller;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import com.example.projets7.entity.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;
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

    Company1 c =new Company1();


    ObservableList<Product> lt = FXCollections.observableArrayList(
            new Clothes("Chaussette", 12.6, 0, 0, 35, 36),
            new Clothes("Clavier", 65.8, 0, 0, 12, 45)
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        c.lprod.add(new Clothes("Chaussette", 12.6, 0, 0, 35, 36));
        c.lprod.add(new Clothes("Clavier", 65.8, 0, 0, 12, 45));
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

        Table.setItems(lt);
        Table.setItems(lt.filtered(Product ->
                Product.getName().toLowerCase().contains(search.getText().toLowerCase())
        ));
        search.textProperty().addListener((observable, oldValue, newValue) ->
                Table.setItems(lt.filtered(Product ->
                        Product.getName().toLowerCase().contains(newValue.toLowerCase())
                )));
        SetCompany();
        NbSize();
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
    private Label ccapital;

    @FXML
    private Label ccost;

    @FXML
    private Label cincome;

    @FXML
    private TextField nsell;

    @FXML
    private TextField nbuy;

    @FXML
    private Label sizeitems;

    @FXML
    private Button button_delete;
    @FXML
    private Button stop_discount;
    @FXML
    private Button apply_discount;

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

    void NbSize(){
        if (lt.size()<=1){
            sizeitems.setText(lt.size()+" Item");
        }
        else {
            sizeitems.setText(lt.size() + " Items");
        }
    }
    void NameEmpty(TextField a){
        if(a.getText().trim().isEmpty()){
            throw new IllegalArgumentException("First name is empty");
        }
    }
    void SetCompany(){
        ccapital.setText("Capital : "+c.getCapital()+" €");
        ccost.setText("Cost : "+c.getGlobalCost()+" €");
        cincome.setText("Income : "+c.getGlobalIncome()+" €");
    }
    void DisplayListe(){
        for (Product p :c.lprod){
            System.out.println(p);
        }
    }


    @FXML
    void AddClothe(ActionEvent event) throws IOException {
        try {
            NameEmpty(cname);
            Clothes cl = new Clothes(cname.getText(), Double.parseDouble(cprice.getText()),
                    0, 0, Integer.parseInt(cstock.getText()), Integer.parseInt(csize.getText()));
            lt.add(cl);
            c.lprod.add(cl);
            cname.clear();
            cprice.clear();
            cstock.clear();
            csize.clear();
            NbSize();
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("An error occurred");
            if (cname.getText().trim().isEmpty() || cprice.getText().trim().isEmpty()
                    || cstock.getText().trim().isEmpty() || csize.getText().trim().isEmpty()){
                alert.setContentText("Textfield is empty");
            }
            else{
                alert.setContentText("Input variable is not a number");
            }
            alert.showAndWait();
        }
    }

    @FXML
    void AddShoe(ActionEvent event) throws IOException {
        try {
            NameEmpty(sname);
            System.out.println(sname.getText().equals(""));
            Shoes s = new Shoes(sname.getText(), Double.parseDouble(sprice.getText()),
                    0, 0, Integer.parseInt(sstock.getText()), Integer.parseInt(ssize.getText()));
            lt.add(s);
            c.lprod.add(s);
            sname.clear();
            sprice.clear();
            sstock.clear();
            ssize.clear();
            NbSize();
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("An error occurred");
            if (sname.getText().trim().isEmpty() || sprice.getText().trim().isEmpty()
                    || sstock.getText().trim().isEmpty() || ssize.getText().trim().isEmpty()){
                alert.setContentText("Textfield is empty");
            }
            else{
                alert.setContentText("Input variable is not a number");
            }
            alert.showAndWait();
        }
    }

    @FXML
    void AddAccessory(ActionEvent event) throws IOException {
        try {
            NameEmpty(aname);
            Accessories a = new Accessories(aname.getText(), Double.parseDouble(aprice.getText()),
                    0, 0, Integer.parseInt(astock.getText()));
            lt.add(a);
            //Table.setItems(lt);
            c.lprod.add(a);
            aname.clear();
            aprice.clear();
            astock.clear();
            NbSize();
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("An error occurred");
            if (aname.getText().trim().isEmpty() || aprice.getText().trim().isEmpty()
                    || astock.getText().trim().isEmpty()){
                alert.setContentText("Textfield is empty");
            }
            else{
                alert.setContentText("Input variable is not a number");
            }
            alert.showAndWait();
        }
    }
    @FXML
    void OnBuy(ActionEvent event) {
        try {
            Product selected = Table.getSelectionModel().getSelectedItem();
            if (Integer.parseInt(nbuy.getText()) > 0) {
                selected.setNbItems(selected.getNbItems() + Integer.parseInt(nbuy.getText()));
                c.setGlobalCosts(c.getGlobalCost() + selected.getPrice() * Integer.parseInt(nbuy.getText()));
                c.setCapital(c.getGlobalIncome() - c.getGlobalCost());
                nbuy.clear();
                SetCompany();
                Table.refresh();
            }
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("An error occurred");
            if(Table.getSelectionModel().getSelectedItem()==null) {
                alert.setContentText("No item has been selected");
            }
            else if (nbuy.getText().trim().isEmpty()){
                alert.setContentText("Textfield is empty");
            }
            else{
                alert.setContentText("Input variable is not a number");
            }
            alert.showAndWait();
        }
    }
    @FXML
    void OnSell(ActionEvent event) {
        try{
        Product selected = Table.getSelectionModel().getSelectedItem();
        if(selected.getNbItems()>=Integer.parseInt(nsell.getText()) && !nsell.getText().isEmpty()){
            selected.setNbItems(selected.getNbItems()-Integer.parseInt(nsell.getText()));
            c.setGlobalIncome(c.getGlobalIncome()+selected.getPrice()*Integer.parseInt(nsell.getText()));
            c.setCapital(c.getGlobalIncome()-c.getGlobalCost());
            nsell.clear();
            SetCompany();
            Table.refresh();
            }
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("An error occurred");
            if(Table.getSelectionModel().getSelectedItem()==null) {
                alert.setContentText("No item has been selected");
            }
            else if (nsell.getText().trim().isEmpty()){
                alert.setContentText("Textfield is empty");
            }
            else{
                alert.setContentText("Input variable is not a number");
            }
            alert.showAndWait();
        }
    }
    @FXML
    void OnDelete(ActionEvent event) {
        Product selected = Table.getSelectionModel().getSelectedItem();
        lt.remove(selected);
        c.lprod.remove(selected);
        NbSize();
    }

    @FXML
    void OnApplyDiscount(ActionEvent event) {
        try {
            Product selected = Table.getSelectionModel().getSelectedItem();
            if (!selected.getDiscount()) {
                selected.applyDiscount();
                Table.refresh();
            }
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("An error occurred");
            alert.setContentText("No item has been selected");
            alert.showAndWait();
        }
    }
    @FXML
    void OnStopDiscount(ActionEvent event) {
        try {
            Product selected = Table.getSelectionModel().getSelectedItem();
            if (selected.getDiscount()) {
                selected.stopDiscount();
                Table.refresh();
            }
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("An error occurred");
            alert.setContentText("No item has been selected");
            alert.showAndWait();
        }
    }

}
