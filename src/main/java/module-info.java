module com.example.projets7 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.projets7 to javafx.fxml;
    exports com.example.projets7.entity;
    opens com.example.projets7.entity to javafx.fxml;
    exports com.example.projets7.util;
    opens com.example.projets7.util to javafx.fxml;
    exports com.example.projets7.controller;
    opens com.example.projets7.controller to javafx.fxml;
}