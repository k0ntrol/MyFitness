package me.fit.resource;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.fit.exception.HolidayException;
import me.fit.model.client.CountryResponse;
import me.fit.model.client.HolidayResponse;
import me.fit.repository.HolidayRepository;
import me.fit.restclient.HolidayClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import java.util.List;

@Path("/holiday/")
public class HolidayResource {

    private final HolidayRepository holidayRepository;
    @RestClient
    private HolidayClient holidayClient;

    @jakarta.inject.Inject
    public HolidayResource(HolidayRepository holidayRepository) {
        this.holidayRepository = holidayRepository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAvailableCountries")
    public Response getAvailableCountries() {
        List<CountryResponse> countries = holidayClient.getAvailableCountries();
        return Response.ok().entity(countries).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getNextHolidays/{countryCode}")
    public Response getNextHolidays(@PathParam("countryCode") String countryCode) {
        List<HolidayResponse> holidays = holidayClient.getNextPublicHolidays(countryCode);

        for (HolidayResponse holiday : holidays) {
            try {
                holidayRepository.addHolidayResponse(holiday);
            } catch (HolidayException e) {
                return Response.ok().entity(e.getMessage()).build();
            }
        }
        return Response.ok().entity(holidays).build();
    }
}
