package me.fit.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.fit.exception.HolidayException;
import me.fit.model.client.HolidayResponse;
import me.fit.model.client.HolidayType;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

@Dependent
public class HolidayRepository {

    @Inject
    EntityManager em;

    @Transactional
    public HolidayResponse addHolidayResponse (HolidayResponse holiday) throws HolidayException {

        holiday.setLaunchYear(LocalDate.parse(holiday.getDate()).getYear());

        if (findByCountryAndYear(holiday.getCountryCode(), holiday.getLaunchYear()) != null) {
            throw new HolidayException("Praznik za ovu godinu i zemlju već postoji");
        }
        return em.merge(holiday);
    }
    @Transactional
    public HolidayType addHolidayType (HolidayType holidayType) {
        return em.merge(holidayType);
    }

    public HolidayResponse findByCountryAndYear(String countryCode, int year){
        HolidayResponse holiday = em.createQuery(HolidayResponse.GET_BY_COUNTRY_AND_YEAR,HolidayResponse.class).setParameter("countryCode", countryCode).setParameter("year", year).getSingleResult();

        return holiday;
    }

    @Transactional
    public List<HolidayResponse> getAllHolidays() {
       List<HolidayResponse> holidays = em.createQuery(HolidayResponse.GET_ALL_HOLIDAYS, HolidayResponse.class).getResultList();

       for (HolidayResponse holiday : holidays) {
           List<HolidayType> types = em.createNamedQuery(HolidayType.GET_TYPES_FOR_HOLIDAY, HolidayType.class).setParameter("holidayId", holiday.getId()).getResultList();
           holiday.setTypes(new HashSet<>(types));
       }

    return holidays;
    }

    @Transactional
    public List<HolidayResponse> getHolidaysByCountry(String countryCode) throws HolidayException {
        List<HolidayResponse> holidays = em.createQuery(HolidayResponse.GET_ALL_HOLIDAYS_BY_COUNTRY, HolidayResponse.class).setParameter("countryCode",countryCode).getResultList();

        if (holidays.size() == 0) {
            throw new HolidayException("Nema pronađenih praznika za datu zemlju");
        }

        return holidays;
    }


}
