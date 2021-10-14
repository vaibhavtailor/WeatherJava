module com.example.weatherjava {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.weatherjava to javafx.fxml;
    exports com.example.weatherjava;
}