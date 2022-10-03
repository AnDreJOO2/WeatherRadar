package com.example.backendmodule.weatherclient.mapper;

import com.example.backendmodule.model.WeatherDto;
import com.example.backendmodule.weatherclient.response.weather.WeatherServiceResponseDto;

import java.util.function.Function;
import java.util.stream.Collectors;

public class ResponseMapper {

    public static Function<WeatherServiceResponseDto, WeatherDto> mapWeatherServiceResponseToDto(){
        return response ->
                new WeatherDto.WeatherDtoBuilder()
                        .withLon(response.getCoord().getLon())
                        .withLat(response.getCoord().getLat())
                        .withCountry(response.getSys().getCountry())
                        .withCityName(response.getName())
                        .withDescription(response.getWeather().get(0).getDescription())
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
