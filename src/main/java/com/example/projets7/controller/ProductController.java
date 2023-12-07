package com.example.projets7.controller;

import com.example.projets7.entity.Product;
import com.example.projets7.util.HibernateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.AnchorPane;
import org.hibernate.Session;

import java.util.ArrayList;

public class ProductController {

        @FXML
        private AnchorPane anchorPane;

        @FXML
        private ListView<String> listView;

        @FXML
        private Button button1;

        @FXML
        private Button button2;

        @FXML
        private void initialize() {
            // Set ListView properties
            listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

            ArrayList<Product> products = new ArrayList<>();

            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                products = (ArrayList<Product>) session.createQuery("from Product", Product.class).list();

                System.out.println(products);

            } catch (Exception e) {
                System.out.println(e);

                e.printStackTrace();
            }

            // Add sample data to the ListView
            //listView.getItems().addAll(products.toArray(String[]::new));

            // Set default selection action
            listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                System.out.println("Selected product: " + newValue);
                // Update your tracking logic here
            });
        }

        @FXML
        private void handleButton1() {
            // Add your Button 1 action logic here
            System.out.println("Button 1 clicked");
        }

        @FXML
        private void handleButton2() {
            // Add your Button 2 action logic here
            System.out.println("Button 2 clicked");
        }
    }



