package com.example.projets7.controller;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.example.projets7.entity.*;
import com.example.projets7.util.HibernateUtil;
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
import javafx.stage.WindowEvent;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import org.hibernate.Session;

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

    private Session hibernateSession;

    ObservableList<Product> lt = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        id.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        name.setOnEditCommit(event ->  {
                Product p = event.getRowValue();
                p.setName(event.getNewValue());
                var transaction = hibernateSession.beginTransaction();
                hibernateSession.merge(p);
                transaction.commit();

        });
        price.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));
        price.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        price.setOnEditCommit(event ->  {
                Product p=event.getRowValue();
                p.setPrice(event.getNewValue());
                var transaction = hibernateSession.beginTransaction();
                hibernateSession.merge(p);
                transaction.commit();
        });
        nbItems.setCellValueFactory(new PropertyValueFactory<Product, Integer>("nbItems"));



        try {

            hibernateSession = HibernateUtil.getSessionFactory().openSession();
            lt.addAll(hibernateSession.createQuery("from Product", Product.class).list());

            System.out.println(lt);

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }

        Table.setItems(lt);
        Table.setItems(lt.filtered(Product ->
                Product.getName().toLowerCase().contains(search.getText().toLowerCase())
        ));
        search.textProperty().addListener((observable, oldValue, newValue) ->
                Table.setItems(lt.filtered(Product ->
                        Product.getName().toLowerCase().contains(newValue.toLowerCase())
                )));
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
    private Button saveBtn;

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
    void DisplayListe(){
        for (Product p :lt){
            System.out.println(p);
        }
    }


    @FXML
    void AddClothe(ActionEvent event) throws IOException {
        Clothes c = new Clothes(cname.getText(), Double.parseDouble(cprice.getText()),
                0, 0, Integer.parseInt(cstock.getText()), Integer.parseInt(csize.getText()));
        lt.add(c);
        var transaction = hibernateSession.beginTransaction();
        hibernateSession.persist(c);
        transaction.commit();
        NbSize();
    }

    @FXML
    void AddShoe(ActionEvent event) throws IOException {
            Shoes s = new Shoes(sname.getText(), Double.parseDouble(sprice.getText()),
                    0, 0, Integer.parseInt(sstock.getText()), Integer.parseInt(ssize.getText()));
            lt.add(s);
            var transaction = hibernateSession.beginTransaction();
            hibernateSession.persist(s);
            transaction.commit();
            NbSize();
    }

    @FXML
    void AddAccessory(ActionEvent event) throws IOException {
        Accessories a = new Accessories(aname.getText(), Double.parseDouble(aprice.getText()),
                0, 0, Integer.parseInt(astock.getText()));
        lt.add(a);
        //Table.setItems(lt);
        var transaction = hibernateSession.beginTransaction();
        hibernateSession.persist(a);
        transaction.commit();
        NbSize();
    }
    @FXML
    void OnBuy(ActionEvent event) {
        Product selected = Table.getSelectionModel().getSelectedItem();
        if(Integer.parseInt(nbuy.getText())>0){
            selected.setNbItems(selected.getNbItems()+Integer.parseInt(nbuy.getText()));
            var transaction = hibernateSession.beginTransaction();
            hibernateSession.merge(selected);
            transaction.commit();
            Table.refresh();
        }
    }
    @FXML
    void OnSell(ActionEvent event) {
        Product selected = Table.getSelectionModel().getSelectedItem();
        if(selected.getNbItems()>=Integer.parseInt(nsell.getText())){
            selected.setNbItems(selected.getNbItems()-Integer.parseInt(nsell.getText()));
            var transaction = hibernateSession.beginTransaction();
            hibernateSession.merge(selected);
            transaction.commit();
            Table.refresh();
        }
    }

    @FXML
    void OnSave(ActionEvent event) {
        try {


            hibernateSession.flush();
        }
        catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }

    }

    @FXML
    void OnDelete(ActionEvent event) {
        Product selected = Table.getSelectionModel().getSelectedItem();
        lt.remove(selected);
        var transaction = hibernateSession.beginTransaction();
        hibernateSession.remove(selected);
        transaction.commit();
        NbSize();
    }

    @FXML
    void OnApplyDiscount(ActionEvent event) {
        Product selected = Table.getSelectionModel().getSelectedItem();
        if(!selected.getDiscount()){
            selected.applyDiscount();
            var transaction = hibernateSession.beginTransaction();
            hibernateSession.merge(selected);
            transaction.commit();
            Table.refresh();
        }
    }
    @FXML
    void OnStopDiscount(ActionEvent event) {
        Product selected = Table.getSelectionModel().getSelectedItem();
        if(selected.getDiscount()){
            selected.stopDiscount();
            var transaction = hibernateSession.beginTransaction();
            hibernateSession.merge(selected);
            transaction.commit();
            Table.refresh();
        }
    }



}
