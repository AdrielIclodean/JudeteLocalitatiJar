package com.judetelocalitati.romania.model;

public class City {

    private String code;
    private String name;
    private String district;
    private String cityType;

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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCityType() {
        return cityType;
    }

    public void setCityType(String cityType) {
        this.cityType = cityType;
    }

    @Override
    public String toString() {
        return "City{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", district='" + district + '\'' +
                ", cityType='" + cityType + '\'' +
                '}';
    }
}
