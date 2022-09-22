package com.example.backendmodule.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "configuration.weather-service")
public class WeatherApiConfiguration {

    private String API_KEY;

    public void setAPI_KEY(String API_KEY) {
        this.API_KEY = API_KEY;
    }

    public String getAPI_KEY() {
        return API_KEY;
    }
}
