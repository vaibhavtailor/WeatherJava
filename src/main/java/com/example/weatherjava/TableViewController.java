package com.example.weatherjava;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TableViewController implements Initializable {

    @FXML
    private TableView<Weather> tableView;


    @FXML
    private TableColumn<Weather, String> locationColumn;

    @FXML
    private TableColumn<Weather, Integer> temperatureColumn;

    @FXML
    private TableColumn<Weather, Integer> windColumn;

    @FXML
    private TableColumn<Weather, String> directionColumn;

    @FXML
    private TableColumn<Weather, String> visibilityColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        temperatureColumn.setCellValueFactory(new PropertyValueFactory<>("temperature"));
        windColumn.setCellValueFactory(new PropertyValueFactory<>("windSpeed"));
        directionColumn.setCellValueFactory(new PropertyValueFactory<>("windDirection"));
        visibilityColumn.setCellValueFactory(new PropertyValueFactory<>("visibility"));

        tableView.getItems().addAll(DBUtility.getWeatherDetails());
    }

    @FXML
    void onButtonClick(ActionEvent event) throws IOException {
        DBUtility.changeScenes(event,"weather-data-view.fxml","WEATHER GRAPHS");

    }

}

