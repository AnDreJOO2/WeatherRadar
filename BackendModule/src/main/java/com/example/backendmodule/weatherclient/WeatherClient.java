package com.example.backendmodule.weatherclient;

import com.example.backendmodule.model.WeatherDto;
import com.example.backendmodule.weatherclient.configuration.WeatherApiConfiguration;
import com.example.backendmodule.weatherclient.mapper.ResponseMapper;
import com.example.backendmodule.weatherclient.response.WeatherServiceResponseDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherClient {

    public static final String API_URL = "https://api.openweathermap.org/data/2.5/";
    public static final String UNITS_METRIC_PARAMETER = "&units=metric";
    public static final String LANG_ENG_PARAMETER = "&lang=eng";
    private final WeatherApiConfiguration configuration;

    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherClient(WeatherApiConfiguration configuration) {
        this.configuration = configuration;
    }

    public WeatherDto getWeatherForCity(String city) {
        WeatherServiceResponseDto response = getApiCall("weather?appid={API_KEY}&q={city}",
                WeatherServiceResponseDto.class,
                configuration.getAPI_KEY(),
                city);
        return ResponseMapper.mapWeatherServiceResponseToDto().apply(response);
    }

    public WeatherDto getWeatherForCoords(float lat, float lon) {
        WeatherServiceResponseDto response = getApiCall("weather?appid={API_KEY}&lat={lat}&lon={lon}",
                WeatherServiceResponseDto.class,
                configuration.getAPI_KEY(),
                lat,
                lon);
        return ResponseMapper.mapWeatherServiceResponseToDto().apply(response);
    }

    public <T> T getApiCall(String url, Class<T> responseType, Object... objects) {
        return restTemplate.getForObject(API_URL + url + UNITS_METRIC_PARAMETER + LANG_ENG_PARAMETER,
                responseType, objects);
    }
}
