package com.judetelocalitati.romania.accessor;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.judetelocalitati.romania.catalogue.Catalogue;
import com.judetelocalitati.romania.model.City;
import com.judetelocalitati.romania.model.CityType;
import com.judetelocalitati.romania.model.District;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

public class ValuesAccessor {
    private static ObjectMapper xmlMapper = new XmlMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private static Catalogue catalogue;

    private static ValuesAccessor instance;

    private ValuesAccessor() {
        //empty
    }

    public static ValuesAccessor getInstance() {
        if (instance == null) {
            instance = new ValuesAccessor();
            try {
                InputStream xmlFile = ValuesAccessor.class.getClassLoader().getResourceAsStream("judeteLocalitatiAdr.xml");
                catalogue = xmlMapper.readValue(xmlFile, Catalogue.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return instance;
    }


    public List<City> getAllCities() {
        return catalogue.getCities();
    }

    /**
     * Use like districtCode = CJ.  Here there might be duplicates like:
     * <City  code="4076" name="Cata" district="BV" cityType="3"/>
     * <City  code="4077" name="Cata" district="BV" cityType="23"/>
     */
    public List<City> getAllCitiesFromDistrict(String districtCode) {
        return catalogue.getCities().stream()
                .filter(city -> city.getDistrict().equals(districtCode))
                .collect(Collectors.toList());
    }

    /**
     * Use like districtCode = CJ and cityType = 2 (Oras ce apartine de judet,altul decat resedinta)
     */
    public List<City> getAllCitiesFromDistrictWithCityType(String districtCode, String cityType) {
        return catalogue.getCities().parallelStream()
                .filter(city -> city.getDistrict().equals(districtCode))
                .filter(city -> city.getCityType().equals(cityType))
                .collect(Collectors.toList());
    }

    public List<District> getAllDistricts() {
        return catalogue.getDistricts();
    }

    public District getDistrictsByCode(String code) {

        return catalogue.getDistricts().stream()
                .filter(district -> district.getCode().equals(code))
                .findFirst().orElse(null);
    }

    public List<CityType> getAllCityTypes() {
        return catalogue.getCityTypes();
    }

}

