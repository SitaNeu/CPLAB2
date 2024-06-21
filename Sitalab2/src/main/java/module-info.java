module com.example.sitalab2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.sitalab2 to javafx.fxml;
    exports com.example.sitalab2;
}