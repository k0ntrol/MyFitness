package me.fit.restclient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import me.fit.model.Weather;
import me.fit.model.client.WeatherResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;


@Path("/weather/")
@RegisterRestClient(configKey = "goweather")
public interface WeatherClient {


    @GET
    @Path("/{city}")
    public WeatherResponse getCurrentWeather(@PathParam("city") String city);

}
