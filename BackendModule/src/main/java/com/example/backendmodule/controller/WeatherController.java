package com.example.backendmodule.controller;

import com.example.backendmodule.model.WeatherDto;
import com.example.backendmodule.service.WeatherService;
import com.example.backendmodule.weatherclient.response.WeatherServiceResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public WeatherDto getWeatherForCity(@RequestParam("city") String city){

        return weatherService.getWeatherForCity(city);
    }


}
