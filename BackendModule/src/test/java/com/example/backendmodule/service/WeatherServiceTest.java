package com.example.backendmodule.service;

import com.example.backendmodule.model.ForecastDto;
import com.example.backendmodule.model.WeatherDto;
import com.example.backendmodule.weatherclient.WeatherClient;
import com.example.backendmodule.weatherclient.response.forecast.processing.ForecastListObjectDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherServiceTest {

    @Mock
    private WeatherClient weatherClient;

    @InjectMocks
    private WeatherService underTest;

    @BeforeEach
    void setUp() {
        underTest = new WeatherService(weatherClient);
    }

    @Test
    void shouldGetWeatherForCity() {
        //given
        String cityName = "Rome";

        WeatherDto expectedWeatherDto = new WeatherDto.WeatherDtoBuilder()
                .withCityName(cityName)
                .withCountry("Italy")
                .withCloudPercentage(23)
                .withDescription("Sunny day")
                .withPressure(1005)
                .withMaximumTemperature(25)
                .withSunset(63456L)
                .withVisibilityInMeters(150)
                .withTemperature(26.3F)
                .withPerceptibleTemperature(28.2F)
                .withMinimumTemperature(19).build();

        //when
        when(weatherClient.getWeatherForCity(cityName)).thenReturn(expectedWeatherDto);
        //then
        assertThat(underTest.getWeatherForCity(cityName))
                .isEqualTo(expectedWeatherDto);
    }

    @Test
    void shouldGetWeatherForCoords() {
        //given
        float givenLat = 48.864716F;
        float givenLon = 2.349014F;

        WeatherDto expectedWeatherDto = new WeatherDto.WeatherDtoBuilder()
                .withCityName("Paris")
                .withCountry("France")
                .withCloudPercentage(16)
                .withDescription("Sunny day")
                .withPressure(1005)
                .withMaximumTemperature(24)
                .withHumidity(44)
                .withWindSpeed(33.4F)
                .withLat(givenLat)
                .withSunrise(22223L)
                .withLon(givenLon)
                .withMinimumTemperature(17).build();

        //when
        when(weatherClient.getWeatherForCoords(givenLat, givenLon)).thenReturn(expectedWeatherDto);
        //then
        assertThat(underTest.getWeatherForCoords(givenLat, givenLon))
                .isEqualTo(expectedWeatherDto);
    }

    @Test
    void shouldGetForecast() {
        //given
        float givenLat = 41.390205f;
        float givenLon = 2.154007f;

        ForecastDto expectedForecastDto = new ForecastDto.ForecastDtoBuilder()
                .withCityName("Barcelona")
                .withLat(givenLat)
                .withLon(givenLon)
                .withCountry("Spain")
                .withCod(332)
                .withCnt(235)
                .withSunrise(22222L)
                .withSunset(33333L)
                .withList(List.of(
                        new ForecastListObjectDto.ForecastListObjectDtoBuilder().withWindSpeed(23.4f).build(),
                        new ForecastListObjectDto.ForecastListObjectDtoBuilder().withHumidity(44).build(),
                        new ForecastListObjectDto.ForecastListObjectDtoBuilder().withPressure(1004).build(),
                        new ForecastListObjectDto.ForecastListObjectDtoBuilder().withTemperature(24.6f).build(),
                        new ForecastListObjectDto.ForecastListObjectDtoBuilder().withCloudPercentage(12).build()
                )).build();

        //when
        when(weatherClient.getForecast(givenLat, givenLon)).thenReturn(expectedForecastDto);
        //then
        assertThat(underTest.getForecast(givenLat, givenLon))
                .isEqualTo(expectedForecastDto);
    }
}
