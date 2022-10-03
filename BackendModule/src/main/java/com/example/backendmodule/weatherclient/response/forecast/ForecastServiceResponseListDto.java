package com.example.backendmodule.weatherclient.response.forecast;

import java.util.List;

public class ForecastServiceResponseListDto {

    private long dt;

    private ForecastServiceResponseMainDto main;
    private List<ForecastServiceResponseWeatherDto> weather;
    private ForecastServiceResponseCloudsDto clouds;
    private ForecastServiceResponseWindDto wind;

    private int visibility;

    public long getDt() {
        return dt;
    }

    public ForecastServiceResponseMainDto getMain() {
        return main;
    }

    public List<ForecastServiceResponseWeatherDto> getWeather() {
        return weather;
    }

    public ForecastServiceResponseCloudsDto getClouds() {
        return clouds;
    }

    public ForecastServiceResponseWindDto getWind() {
        return wind;
    }

    public int getVisibility() {
        return visibility;
    }

}
