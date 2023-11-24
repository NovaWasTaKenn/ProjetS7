module com.example.projets7 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projets7 to javafx.fxml;
    exports com.example.projets7;
}