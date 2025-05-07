package me.fit.repository;


import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.transaction.Transactional;
import me.fit.model.Forecast;
import me.fit.model.Weather;
import me.fit.model.client.HolidayResponse;
import me.fit.model.client.WeatherResponse;

import java.util.HashSet;
import java.util.List;

@Dependent
public class WeatherRepository {

    @Inject
    EntityManager em;

    @Transactional
    public Weather addWeather (Weather w) {

        return em.merge(w);
    }

    public Forecast addForecast (Forecast f) {
        return em.merge(f);
    }


    @Transactional
    public List<Weather> getWeather (){

        List<Weather> weather = em.createNamedQuery(Weather.GET_WEATHER).getResultList();

        for (Weather w : weather) {
            List<Forecast> forecasts = em.createNamedQuery(Forecast.GET_FORECAST).setParameter("weatherId",w.getId()).getResultList();
            w.setForecasts(new HashSet<>(forecasts));

        }

    return weather;
    }

}
