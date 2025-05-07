package me.fit.model;

import jakarta.persistence.*;

@Entity
@NamedQueries(
        {
                @NamedQuery(name = Forecast.GET_FORECAST, query = "select f from Forecast f where f.weather.id = :weatherId")
        }

)
public class Forecast {

    public static final String GET_FORECAST = "getForecast";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String day;
    private String temperature;
    private String wind;
    @ManyToOne
    private Weather weather;

    public Forecast() {
    }

    public Forecast(String day, String temperature, String wind,Weather weather) {
        this.day = day;
        this.temperature = temperature;
        this.wind = wind;
        this.weather = weather;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
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

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }
}
