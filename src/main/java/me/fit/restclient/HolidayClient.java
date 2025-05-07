package me.fit.restclient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import me.fit.model.client.CountryResponse;
import me.fit.model.client.HolidayApiResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/api/v3")
@RegisterRestClient(configKey = "nager-date-api")
public interface HolidayClient {

    @GET
    @Path("/AvailableCountries")
    List<CountryResponse> getAvailableCountries();

    @GET
    @Path("/NextPublicHolidays/{countryCode}")
    List<HolidayApiResponse> getNextPublicHolidays(@PathParam("countryCode") String countryCode);

}
