package com.example.backendmodule.weatherclient.response.forecast;

public class ForecastServiceResponseCityDto {

    private String name;
    private ForecastServiceResponseCoordDto coord;
    private String country;
    private Long sunrise;
    private Long sunset;

    public String getName() {
        return name;
    }

    public ForecastServiceResponseCoordDto getCoord() {
        return coord;
    }

    public String getCountry() {
        return country;
    }

    public Long getSunrise() {
        return sunrise;
    }

    public Long getSunset() {
        return sunset;
    }
}
