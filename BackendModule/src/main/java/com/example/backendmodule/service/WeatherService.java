package com.example.backendmodule.service;

import com.example.backendmodule.model.WeatherDto;
import com.example.backendmodule.weatherclient.WeatherClient;
import com.example.backendmodule.weatherclient.response.WeatherServiceResponseDto;
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
}
