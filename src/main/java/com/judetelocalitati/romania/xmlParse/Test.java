package com.judetelocalitati.romania.xmlParse;

import com.judetelocalitati.romania.accessor.ValuesAccessor;

public class Test {
    public static void main(String[] args) {

        ValuesAccessor valuesAccessor = ValuesAccessor.getInstance();


        System.out.println(valuesAccessor.getAllCityTypes());
        System.out.println(valuesAccessor.getAllCities().size());

        System.out.println(valuesAccessor.getAllCitiesFromDistrict("CJ"));

        System.out.println(valuesAccessor.getAllDistricts());
    }
}
