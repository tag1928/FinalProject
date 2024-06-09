module com.example.finalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens com.example.finalproject to javafx.fxml;
    exports com.example.finalproject;
}