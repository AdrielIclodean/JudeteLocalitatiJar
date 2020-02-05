package com.judetelocalitati.romania.catalogue;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.judetelocalitati.romania.model.*;

import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement(localName = "Catalogue")
public class Catalogue {

    @JacksonXmlElementWrapper(localName = "Countries")
    @JacksonXmlProperty(localName = "Country")
    private List<Country> countries = new ArrayList<>();

    @JacksonXmlElementWrapper(localName = "Districts")
    @JacksonXmlProperty(localName = "District")
    private List<District> districts = new ArrayList<>();

    @JacksonXmlElementWrapper(localName = "CityTypes")
    @JacksonXmlProperty(localName = "CityType")
    private List<CityType> cityTypes = new ArrayList<>();

    @JacksonXmlElementWrapper(localName = "Cities")
    @JacksonXmlProperty(localName = "City")
    private List<City> cities = new ArrayList<>();

    @JacksonXmlElementWrapper(localName = "Streets")
    @JacksonXmlProperty(localName = "Street")
    private List<Street> streets = new ArrayList<>();

    @JacksonXmlElementWrapper(localName = "Street_Types")
    @JacksonXmlProperty(localName = "Street_Type")
    private List<StreetType> streetTypes = new ArrayList<>();

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }

    public List<CityType> getCityTypes() {
        return cityTypes;
    }

    public void setCityTypes(List<CityType> cityTypes) {
        this.cityTypes = cityTypes;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public List<Street> getStreets() {
        return streets;
    }

    public void setStreets(List<Street> streets) {
        this.streets = streets;
    }

    public List<StreetType> getStreetTypes() {
        return streetTypes;
    }

    public void setStreetTypes(List<StreetType> streetTypes) {
        this.streetTypes = streetTypes;
    }
}
