package com.example.backendmodule.service;

import com.example.backendmodule.weatherclient.WeatherClient;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private final WeatherClient weatherClient;

    public WeatherService(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    public String getWeather(){
        return weatherClient.getApiCall();
    }
}
