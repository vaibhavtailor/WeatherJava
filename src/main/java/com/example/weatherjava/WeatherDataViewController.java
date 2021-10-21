package com.example.weatherjava;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;

import java.net.URL;
import java.util.ResourceBundle;

public class WeatherDataViewController implements Initializable {

    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis locationAxis;

    @FXML
    private NumberAxis temperatureAxis;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        barChart.getData().addAll(DBUtility.getSalesData());
        barChart.setLegendVisible(false);

        locationAxis.setLabel("Location");
        temperatureAxis.setLabel("Temperature");
    }
}