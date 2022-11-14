module com.example.projectjavafx2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.projectjavafx2 to javafx.fxml;
    exports com.example.projectjavafx2;
}