package com.example.backendmodule.controller;

import com.example.backendmodule.model.WeatherDto;
import com.example.backendmodule.service.WeatherService;
import com.example.backendmodule.weatherclient.response.forecast.ForecastServiceResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public ResponseEntity<WeatherDto> getWeatherForCity(@RequestParam("city") String city) {
        return new ResponseEntity<>(weatherService.getWeatherForCity(city), HttpStatus.OK);
    }

    @GetMapping("/weather/coords")
    public ResponseEntity<WeatherDto> getWeatherForCoords(@RequestParam("lat") float lat, @RequestParam("lon") float lon) {
        return new ResponseEntity<>(weatherService.getWeatherForCoords(lat, lon), HttpStatus.OK);
    }

    @GetMapping("/forecast")
    public ResponseEntity<ForecastServiceResponseDto> getForecast(@RequestParam("lat") float lat, @RequestParam("lon") float lon) {
        return new ResponseEntity<>(weatherService.getForecast(lat, lon), HttpStatus.OK);
    }


}
