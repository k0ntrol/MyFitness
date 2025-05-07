package me.fit.model;

import jakarta.persistence.*;
import me.fit.model.client.ForecastResponse;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


@Entity
@NamedQueries(
        {
                @NamedQuery(name = Weather.GET_WEATHER, query = "Select w from Weather w")
        }
)
public class Weather {
    public static final String GET_WEATHER = "getWeather";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String temperature;
    private String wind;
    private String description;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "weather_id")
    private Set<Forecast> forecasts = new HashSet<>();

    public Weather() {
    }

    public Weather(String temperature, String description, String wind, Set<Forecast> forecasts) {
        this.temperature = temperature;
        this.description = description;
        this.wind = wind;
        this.forecasts = forecasts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<Forecast> getForecasts() {
        return forecasts;
    }

    public void setForecasts(Set<Forecast> forecasts) {
        this.forecasts = forecasts;
    }
}
