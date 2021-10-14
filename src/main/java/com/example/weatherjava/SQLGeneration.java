package com.example.weatherjava;

import javafx.application.Preloader;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.*;

public class SQLGeneration {

    /**
     * This method will create random camera sales data that matches the pattern
     * INSERT INTO cameraSales (cameraId, dateSold) VALUES (7, '2021-04-26');
     */
    public static void createSQL()
    {
        //create a random number generator
        SecureRandom random = new SecureRandom();

        //create a  list of cities in ontario so that can call it randomly
        String[] cities = {"Toronto", "Brampton", "Mississauga", "Vaughan", "Barrie", "Ottawa", "Hamilton", "Orillia",
                            "North York", "Windsor", "London", "North Bay", "Oshawa", "WaterLoo", "Kitchener"};


        //Create a list of direction
        String[] direction = {"North", "South", "East", "West"};
;


        //open the formatter in the try with resources block so that it will auto close
        try(
                Formatter formatter = new Formatter("weather.sql");
        )
        {
            //loop 5000 times to create random records
            for (int i=1; i<=1000; i++)
            {
                int randomCity = random.nextInt(cities.length);
                int randomDir = random.nextInt(direction.length);
                formatter.format("Insert Into weather (Location, Temperature, Wind, WindDirection, Visibility) values ('%s', %d, %d, '%s', %d);%n", cities[randomCity], random.nextInt( 40+1), random.nextInt( 20+1), direction[randomDir] , random.nextInt( 20+1));
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void readFile()
    {
        try {
            Scanner scanner = new Scanner(new File("weather.sql"));

            while (scanner.hasNext())
            {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        createSQL();
    }
}
