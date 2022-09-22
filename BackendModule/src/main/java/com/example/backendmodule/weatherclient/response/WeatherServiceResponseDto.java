package com.example.backendmodule.weatherclient.response;

import java.util.List;

public class WeatherServiceResponseDto {

    private List<WeatherServiceResponseWeatherDto> weather;
    private WeatherServiceResponseMainDto main;
    private WeatherServiceResponseWindDto wind;
    private WeatherServiceResponseCloudDto clouds;
    private WeatherServiceResponseSysDto sys;

    private int visibility;
    private String name;

    public List<WeatherServiceResponseWeatherDto> getWeather() {
        return weather;
    }

    public WeatherServiceResponseMainDto getMain() {
        return main;
    }

    public WeatherServiceResponseWindDto getWind() {
        return wind;
    }

    public WeatherServiceResponseCloudDto getClouds() {
        return clouds;
    }

    public WeatherServiceResponseSysDto getSys() {
        return sys;
    }

    public int getVisibility() {
        return visibility;
    }

    public String getName() {
        return name;
    }

}
