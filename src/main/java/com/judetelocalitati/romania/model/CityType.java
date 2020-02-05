package com.judetelocalitati.romania.model;

public class CityType {
    private String code;
    private String name;
    private boolean urbanFlag;

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

    public boolean isUrbanFlag() {
        return urbanFlag;
    }

    public void setUrbanFlag(boolean urbanFlag) {
        this.urbanFlag = urbanFlag;
    }

    @Override
    public String toString() {
        return "CityType{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", urbanFlag=" + urbanFlag +
                '}';
    }
}
