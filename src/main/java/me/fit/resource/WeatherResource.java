package me.fit.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.fit.model.Forecast;
import me.fit.model.Weather;
import me.fit.model.client.ForecastResponse;
import me.fit.model.client.WeatherResponse;
import me.fit.repository.WeatherRepository;
import me.fit.restclient.WeatherClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Path("/weather/")
public class WeatherResource {

    private final WeatherRepository weatherRepository;
    @RestClient
    public WeatherClient weatherClient;

    @jakarta.inject.Inject
    public WeatherResource(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getForecast/{city}")
    public Response getCity(@PathParam("city") String city) {
        WeatherResponse weatherResponse = weatherClient.getCurrentWeather(city);
        ArrayList<ForecastResponse> forecasts = weatherResponse.getForecast();
        Weather w = new Weather();
            w.setWind(weatherResponse.getWind());
            w.setTemperature(weatherResponse.getTemperature());
            w.setDescription(weatherResponse.getDescription());
        
        List<Weather> saved = new ArrayList<>();
        Set<Forecast> fcast = new HashSet<>();
        for (ForecastResponse forecast : forecasts) {
            Forecast f = new Forecast();
            f.setWind(forecast.getWind());
            f.setTemperature(forecast.getTemperature());
            f.setDay(forecast.getDay());
            fcast.add(f);

        }
        w.setForecasts(fcast);

        try {
                weatherRepository.addWeather(w);
                saved.add(w);
        }catch (Exception e){
            System.out.println("Error in saving weather for city " + city);
        }

        return Response.ok().entity(weatherResponse).build();
    }
}
