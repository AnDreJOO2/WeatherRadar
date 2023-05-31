package com.example.backendmodule.weatherclient;

import com.example.backendmodule.model.ForecastDto;
import com.example.backendmodule.model.WeatherDto;
import com.example.backendmodule.weatherclient.configuration.WeatherApiConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class WeatherClientTest {

    @Autowired
    private WeatherApiConfiguration weatherApiConfiguration;

    private WeatherClient underTest;

    @BeforeEach
    void setUp() {
        underTest = new WeatherClient(weatherApiConfiguration);
    }

    @Test
    void shouldGetWeatherForCity() {
        //given
        String cityName = "Warsaw";
        //when
        //then
        assertThat(underTest.getWeatherForCity(cityName))
                .isNotNull()
                .isInstanceOf(WeatherDto.class);
    }

    @Test
    void shouldGetWeatherForCoords() {
        //given
        float givenLat = 41.390205f;
        float givenLon = 2.154007f;
        //when
        //then
        assertThat(underTest.getWeatherForCoords(givenLat, givenLon))
                .isNotNull()
                .isInstanceOf(WeatherDto.class);
    }

    @Test
    void shouldFetForecast() {
        //given
        float givenLat = 48.864716f;
        float givenLon = 2.349014f;
        //when
        //then
        assertThat(underTest.getForecast(givenLat, givenLon))
                .isNotNull()
                .isInstanceOf(ForecastDto.class);
    }
}
