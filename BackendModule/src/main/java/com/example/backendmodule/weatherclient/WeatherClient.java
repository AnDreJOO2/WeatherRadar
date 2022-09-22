package com.example.backendmodule.weatherclient;

import com.example.backendmodule.weatherclient.configuration.WeatherApiConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherClient {

    public static final String API_URL = "https://api.openweathermap.org/data/2.5/";
    public static final String UNITS_METRIC_PARAMETER = "&units=metric";
    public static final String LANG_PL_PARAMETER = "&lang=pl";
    private final WeatherApiConfiguration configuration;

    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherClient(WeatherApiConfiguration configuration) {
        this.configuration = configuration;
    }

    public String getWeatherForCity(String city) {
        return getApiCall("weather?appid={API_KEY}&q={city}",
                String.class,
                configuration.getAPI_KEY(),
                city);
    }

    public <T> T getApiCall(String url, Class<T> responseType, Object... objects) {
        return restTemplate.getForObject(API_URL+url + UNITS_METRIC_PARAMETER + LANG_PL_PARAMETER,
                responseType, objects);
    }
}
