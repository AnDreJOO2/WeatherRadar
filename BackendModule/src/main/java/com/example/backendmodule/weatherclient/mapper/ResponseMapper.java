package com.example.backendmodule.weatherclient.mapper;

import com.example.backendmodule.model.WeatherDto;
import com.example.backendmodule.weatherclient.response.WeatherServiceResponseDto;

import java.util.function.Function;

public class ResponseMapper {

    public static Function<WeatherServiceResponseDto, WeatherDto> mapWeatherServiceResponseToDto(){
        return response ->
                new WeatherDto.WeatherDtoBuilder()
                        .withCountry(response.getSys().getCountry())
                        .withCityName(response.getName())
                        .withDescription(String.valueOf(response.getWeather().stream().map(element -> element.getDescription()).findFirst()))
                        .withSunrise(response.getSys().getSunrise())
                        .withSunset(response.getSys().getSunset())
                        .withVisibilityInMeters(response.getVisibility())
                        .withTemperature(response.getMain().getTemp())
                        .withPerceptibleTemperature(response.getMain().getFeels_like())
                        .withMinimumTemperature(response.getMain().getTemp_min())
                        .withMaximumTemperature(response.getMain().getTemp_max())
                        .withPressure(response.getMain().getPressure())
                        .withHumidity(response.getMain().getHumidity())
                        .withWindSpeed(response.getWind().getSpeed())
                        .withCloudPercentage(response.getClouds().getAll())
                        .build();
    }
}
