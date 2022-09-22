package com.example.backendmodule.weatherclient;

import com.example.backendmodule.weatherclient.configuration.WeatherApiConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherClient {

    public static final String API_URL = "https://api.openweathermap.org/data/2.5/";
    private final WeatherApiConfiguration configuration;

    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherClient(WeatherApiConfiguration configuration) {
        this.configuration = configuration;
    }

    public String getApiCall(){
        return restTemplate.getForObject(API_URL+"weather?appid={API_KEY}&q=Warszawa&units=metric&lang=pl", String.class, configuration.getAPI_KEY());
    }
}
