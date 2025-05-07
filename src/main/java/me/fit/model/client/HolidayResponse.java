package me.fit.model.client;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;


@Entity
@NamedQueries({
        @NamedQuery(name = HolidayResponse.GET_ALL_HOLIDAYS, query = "Select h from HolidayResponse h"),
        @NamedQuery(name = HolidayResponse.GET_ALL_HOLIDAYS_BY_COUNTRY, query = "Select h from HolidayResponse h where h.countryCode =:countryCode"),

})
public class HolidayResponse {
    public static final String GET_ALL_HOLIDAYS = "HolidayResponse.getAllHolidays";
    public static final String GET_ALL_HOLIDAYS_BY_COUNTRY = "HolidayResponse.getAllHolidaysByCountry";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private String localName;
    private String name;
    private String countryCode;
    private boolean fixed;
    private boolean global;
    private int launchYear;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "holiday_id")
    public Set<HolidayType> types = new HashSet<>();


    public HolidayResponse() {
        super();
    }

    public HolidayResponse(String date, String localName, String name, String countryCode, boolean fixed, int launchYear, boolean global, Set<HolidayType> types) {
        this.date = date;
        this.localName = localName;
        this.name = name;
        this.countryCode = countryCode;
        this.fixed = fixed;
        this.launchYear = launchYear;
        this.global = global;
        this.types = types;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public boolean isGlobal() {
        return global;
    }

    public void setGlobal(boolean global) {
        this.global = global;
    }

    public int getLaunchYear() {
        return launchYear;
    }

    public void setLaunchYear(int launchYear) {
        this.launchYear = launchYear;
    }

    public Set<HolidayType> getTypes() {
        return types;
    }

    public void setTypes(Set<HolidayType> types) {
        this.types = types;
    }

    public boolean isFixed() {
        return fixed;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }
}
