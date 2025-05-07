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
import me.fit.model.client.HolidayApiResponse;
import me.fit.model.client.HolidayResponse;
import me.fit.model.client.HolidayType;
import me.fit.repository.HolidayRepository;
import me.fit.restclient.HolidayClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
        List<HolidayApiResponse> holidays = holidayClient.getNextPublicHolidays(countryCode);

        List<HolidayResponse> saved = new ArrayList<>();
        for (HolidayApiResponse holiday : holidays) {
            HolidayResponse h = new HolidayResponse();
            h.setDate(holiday.date);
            h.setLocalName(holiday.localName);
            h.setName(holiday.name);
            h.setCountryCode(holiday.countryCode);
            h.setFixed(holiday.fixed);
            h.setGlobal(holiday.global);
            h.setLaunchYear(holiday.launchYear);

            HolidayType ht = new HolidayType();
            ht.setTypeName(holiday.type);
            ht.setHoliday(h);
            h.setTypes(Set.of(ht));
            try {
                holidayRepository.addHolidayResponse(h);
                saved.add(h);
            } catch (HolidayException e) {
                System.out.println("Praznik već postoji");
            }

        }
        return Response.ok().entity(holidays).build();

    }
}
