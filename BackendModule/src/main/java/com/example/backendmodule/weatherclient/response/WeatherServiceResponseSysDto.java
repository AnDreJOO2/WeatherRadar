package com.example.backendmodule.weatherclient.response;

public class WeatherServiceResponseSysDto {

    private String country;
    private long sunrise;
    private long sunset;

    public String getCountry() {
        return country;
    }

    public long getSunrise() {
        return sunrise;
    }

    public long getSunset() {
        return sunset;
    }

}
