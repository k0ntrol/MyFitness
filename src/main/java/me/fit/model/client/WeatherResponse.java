package me.fit.model.client;

import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

import java.util.ArrayList;

public class WeatherResponse {

    private String temperature;
    private String wind;
    private String description;
    private ArrayList<ForecastResponse> forecast;

    public WeatherResponse() {
    }

    public WeatherResponse(String temperature, String wind, String description, ArrayList<ForecastResponse> forecast) {
        this.temperature = temperature;
        this.wind = wind;
        this.description = description;
        this.forecast = forecast;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<ForecastResponse> getForecast() {
        return forecast;
    }

    public void setForecast(ArrayList<ForecastResponse> forecast) {
        this.forecast = forecast;
    }

    @Override
    public String toString() {
        return "WeatherResponse{" +
                "temperature='" + temperature + '\'' +
                ", wind='" + wind + '\'' +
                ", description='" + description + '\'' +
                ", forecast=" + forecast +
                '}';
    }
}
