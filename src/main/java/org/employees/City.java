package org.employees;

import java.util.Objects;

public class City {

    private int cityID;
    private String cityName;

    public City() {
    }

    public City(int cityID, String cityName) {
        this.cityID = cityID;
        this.cityName = cityName;
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return cityID == city.cityID && cityName.equals(city.cityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityID, cityName);
    }
}
