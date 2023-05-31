package com.example.backendmodule.model;

import com.example.backendmodule.weatherclient.response.forecast.processing.ForecastListObjectDto;
import com.example.backendmodule.weatherclient.response.forecast.processing.Utils;

import java.time.ZoneOffset;
import java.util.List;

public class ForecastDto {

    private final int cod;
    private final int cnt;
    private final List<ForecastListObjectDto> list;
    private final String country;
    private final String cityName;
    private final float lat;
    private final float lon;
    private final String sunrise;
    private final String sunset;

    private ForecastDto(ForecastDtoBuilder builder) {
        this.cod = builder.cod;
        this.cnt = builder.cnt;
        this.list = builder.list;
        this.country = builder.country;
        this.cityName = builder.cityName;
        this.lon = builder.lon;
        this.lat = builder.lat;
        this.sunrise = builder.sunrise;
        this.sunset = builder.sunset;
    }


    public static class ForecastDtoBuilder {
        private int cod;
        private int cnt;
        private List<ForecastListObjectDto> list;
        private String country;
        private String cityName;

        private float lat;
        private float lon;
        private String sunrise;
        private String sunset;

        public ForecastDtoBuilder withCod(int cod) {
            this.cod = cod;
            return this;
        }

        public ForecastDtoBuilder withCnt(int cnt) {
            this.cnt = cnt;
            return this;
        }

        public ForecastDtoBuilder withList(List<ForecastListObjectDto> list) {
            this.list = list;
            return this;
        }

        public ForecastDtoBuilder withCountry(String country) {
            this.country = country;
            return this;
        }

        public ForecastDtoBuilder withCityName(String cityName) {
            this.cityName = cityName;
            return this;
        }

        public ForecastDtoBuilder withLat(float lat) {
            this.lat = lat;
            return this;
        }

        public ForecastDtoBuilder withLon(float lon) {
            this.lon = lon;
            return this;
        }

        public ForecastDtoBuilder withSunrise(long sunrise) {
            this.sunrise = Utils.getFormattedLocalDateTime(sunrise, ZoneOffset.UTC);
            return this;
        }

        public ForecastDtoBuilder withSunset(long sunset) {
            this.sunset = Utils.getFormattedLocalDateTime(sunset, ZoneOffset.UTC);
            return this;
        }

        public ForecastDto build() {
            return new ForecastDto(this);
        }

    }
}
