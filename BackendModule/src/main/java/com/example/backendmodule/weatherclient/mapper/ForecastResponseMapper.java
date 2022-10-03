package com.example.backendmodule.weatherclient.mapper;

import com.example.backendmodule.model.ForecastDto;
import com.example.backendmodule.weatherclient.response.forecast.ForecastServiceResponseDto;
import com.example.backendmodule.weatherclient.response.forecast.ForecastServiceResponseListDto;
import com.example.backendmodule.weatherclient.response.forecast.processing.ForecastListObjectDto;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ForecastResponseMapper {

    public static Function<ForecastServiceResponseDto, ForecastDto> mapForecastServiceResponseDtoToForecastDto() {
        return data -> new ForecastDto.ForecastDtoBuilder()
                .withCod(data.getCod())
                .withCnt(data.getCnt())
                .withList(mapForecastListToForecastListDao(data.getList()))
                .withCountry(data.getCity().getCountry())
                .withCityName(data.getCity().getName())
                .withLat(data.getCity().getCoord().getLat())
                .withLon(data.getCity().getCoord().getLon())
                .withSunrise(data.getCity().getSunrise())
                .withSunset(data.getCity().getSunset())
                .build();
    }

    public static List<ForecastListObjectDto> mapForecastListToForecastListDao(List<ForecastServiceResponseListDto> data) {
        return data.stream().map(element -> mapForecastListResponseToForecastListDto().apply(element)).collect(Collectors.toList());
    }

    public static Function<ForecastServiceResponseListDto, ForecastListObjectDto> mapForecastListResponseToForecastListDto() {
        return data ->
                new ForecastListObjectDto.ForecastListObjectDtoBuilder()
                        .withForecastTime(data.getDt())
                        .withMinimumTemperature(data.getMain().getTemp_min())
                        .withMaximumTemperature(data.getMain().getTemp_max())
                        .withTemperature(data.getMain().getTemp())
                        .withPerceptibleTemperature(data.getMain().getFeels_like())
                        .withPressure(data.getMain().getPressure())
                        .withHumidity(data.getMain().getHumidity())
                        .withDescription(data.getWeather().get(0).getDescription())
                        .withCloudPercentage(data.getClouds().getAll())
                        .withWindSpeed(data.getWind().getSpeed())
                        .withVisibilityInMeters(data.getVisibility())
                        .build();
    }
}
