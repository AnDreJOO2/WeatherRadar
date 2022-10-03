package com.example.backendmodule.weatherclient.mapper;

import com.example.backendmodule.model.WeatherDto;
import com.example.backendmodule.weatherclient.response.weather.WeatherServiceResponseDto;

import java.util.function.Function;

public class WeatherResponseMapper {

    public static Function<WeatherServiceResponseDto, WeatherDto> mapWeatherServiceResponseToDto() {
        return data ->
                new WeatherDto.WeatherDtoBuilder()
                        .withLon(data.getCoord().getLon())
                        .withLat(data.getCoord().getLat())
                        .withCountry(data.getSys().getCountry())
                        .withCityName(data.getName())
                        .withDescription(data.getWeather().get(0).getDescription())
                        .withSunrise(data.getSys().getSunrise())
                        .withSunset(data.getSys().getSunset())
                        .withVisibilityInMeters(data.getVisibility())
                        .withTemperature(data.getMain().getTemp())
                        .withPerceptibleTemperature(data.getMain().getFeels_like())
                        .withMinimumTemperature(data.getMain().getTemp_min())
                        .withMaximumTemperature(data.getMain().getTemp_max())
                        .withPressure(data.getMain().getPressure())
                        .withHumidity(data.getMain().getHumidity())
                        .withWindSpeed(data.getWind().getSpeed())
                        .withCloudPercentage(data.getClouds().getAll())
                        .build();
    }
}
