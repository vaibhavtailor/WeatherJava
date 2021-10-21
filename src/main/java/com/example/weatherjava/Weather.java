package com.example.weatherjava;

public class Weather {

    private String location;
    private int temperature;
    private int windSpeed;
    private String windDirection;
    private String visibility;

    public Weather(String location, int temperature, int windSpeed, String windDirection, String visibility) {
        setLocation(location);
        setTemperature(temperature);
        setWindSpeed(windSpeed);
        setWindDirection(windDirection);
        setVisibility(visibility);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }
}
