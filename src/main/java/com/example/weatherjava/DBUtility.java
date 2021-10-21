package com.example.weatherjava;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBUtility {
    private static String user = "student";
    private static String pw = "student";
    private static String connectUrl = "jdbc:mysql://localhost:3306/javaProjects";

    public static XYChart.Series<String, Integer> getSalesData()
    {
        XYChart.Series<String, Integer> weatherData = new XYChart.Series<>();

        String sql = "SELECT Location, Temperature FROM weather;";

        //use the try with resources ensure that anything opened in the ( ... ) will be closed
        try(
                Connection conn = DriverManager.getConnection(connectUrl, user,pw);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        )
        {
            while (resultSet.next())
            {
                weatherData.getData().add(new XYChart.Data<>(resultSet.getString("Location"), resultSet.getInt("Temperature")));
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return weatherData;
    }

    public static ArrayList<Weather> getWeatherDetails()
    {
        ArrayList<Weather> weathers = new ArrayList<>();

        String sql = "SELECT weather.Location, Temperature, Wind, WindDirection, Visibility \n" +
                "FROM weather;";

        //use the try with resources ensure that anything opened in the ( ... ) will be closed
        try(
                Connection conn = DriverManager.getConnection(connectUrl, user,pw);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        )
        {
            while (resultSet.next())
            {
                
                String location = resultSet.getString("location");
                int temperature = resultSet.getInt("temperature");
                int wind = resultSet.getInt("wind");
                String direction = resultSet.getString("windDirection");
                String visibility = resultSet.getString("visibility");

                Weather weather = new Weather(location, temperature, wind, direction, visibility);


                weathers.add(weather);
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return weathers;
    }

    public static void changeScenes(ActionEvent event, String fxmlFileLocation, String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxmlFileLocation));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
}
