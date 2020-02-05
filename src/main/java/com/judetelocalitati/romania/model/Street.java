package com.judetelocalitati.romania.model;

public class Street {
    private String code;
    private String name;
    private String cityCode;
    private String streetType;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getStreetType() {
        return streetType;
    }

    public void setStreetType(String streetType) {
        this.streetType = streetType;
    }

    @Override
    public String toString() {
        return "Street{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", streetType='" + streetType + '\'' +
                '}';
    }
}
