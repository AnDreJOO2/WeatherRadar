package com.example.backendmodule.service;

import com.example.backendmodule.model.WeatherDto;
import com.example.backendmodule.weatherclient.WeatherClient;
import com.example.backendmodule.weatherclient.response.forecast.ForecastServiceResponseDto;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private final WeatherClient weatherClient;

    public WeatherService(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }


    public WeatherDto getWeatherForCity(String city) {
        return weatherClient.getWeatherForCity(city);
    }

    public WeatherDto getWeatherForCoords(float lat, float lon) {
        return weatherClient.getWeatherForCoords(lat, lon);
    }

    public ForecastServiceResponseDto getForecast(float lat, float lon) {
        return weatherClient.getForecast(lat, lon);
    }
}
