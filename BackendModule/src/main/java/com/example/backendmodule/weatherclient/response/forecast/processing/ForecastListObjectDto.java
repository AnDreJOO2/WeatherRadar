package com.example.backendmodule.weatherclient.response.forecast.processing;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class ForecastListObjectDto {

    private final String forecastTime;
    private final float minimumTemperature;
    private final float maximumTemperature;
    private final float temperature;
    private final float perceptibleTemperature;
    private final int pressure;
    private final int humidity;
    private final String description;
    private final int cloudPercentage;
    private final float windSpeed;
    private final int visibilityInMeters;

    private ForecastListObjectDto(ForecastListObjectDtoBuilder builder) {
        this.forecastTime = builder.forecastTime;
        this.minimumTemperature = builder.minimumTemperature;
        this.maximumTemperature = builder.maximumTemperature;
        this.temperature = builder.temperature;
        this.perceptibleTemperature = builder.perceptibleTemperature;
        this.pressure = builder.pressure;
        this.humidity = builder.humidity;
        this.description = builder.description;
        this.cloudPercentage = builder.cloudPercentage;
        this.windSpeed = builder.windSpeed;
        this.visibilityInMeters = builder.visibilityInMeters;
    }

    public String getForecastTime() {
        return forecastTime;
    }

    public float getMinimumTemperature() {
        return minimumTemperature;
    }

    public float getMaximumTemperature() {
        return maximumTemperature;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getPerceptibleTemperature() {
        return perceptibleTemperature;
    }

    public int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public String getDescription() {
        return description;
    }

    public int getCloudPercentage() {
        return cloudPercentage;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public int getVisibilityInMeters() {
        return visibilityInMeters;
    }

    public static class ForecastListObjectDtoBuilder {
        private String forecastTime;
        private float minimumTemperature;
        private float maximumTemperature;
        private float temperature;
        private float perceptibleTemperature;
        private int pressure;
        private int humidity;
        private String description;
        private int cloudPercentage;
        private float windSpeed;
        private int visibilityInMeters;

        public ForecastListObjectDtoBuilder withForecastTime(long forecastTime) {
            this.forecastTime = Utils.getFormattedLocalDateTime(forecastTime, ZoneOffset.UTC);
            return this;
        }

        public ForecastListObjectDtoBuilder withMinimumTemperature(float minimumTemperature) {
            this.minimumTemperature = minimumTemperature;
            return this;
        }

        public ForecastListObjectDtoBuilder withMaximumTemperature(float maximumTemperature) {
            this.maximumTemperature = maximumTemperature;
            return this;
        }

        public ForecastListObjectDtoBuilder withTemperature(float temperature) {
            this.temperature = temperature;
            return this;
        }

        public ForecastListObjectDtoBuilder withPerceptibleTemperature(float perceptibleTemperature) {
            this.perceptibleTemperature = perceptibleTemperature;
            return this;
        }

        public ForecastListObjectDtoBuilder withPressure(int pressure) {
            this.pressure = pressure;
            return this;
        }

        public ForecastListObjectDtoBuilder withHumidity(int humidity) {
            this.humidity = humidity;
            return this;
        }

        public ForecastListObjectDtoBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public ForecastListObjectDtoBuilder withCloudPercentage(int cloudPercentage) {
            this.cloudPercentage = cloudPercentage;
            return this;
        }

        public ForecastListObjectDtoBuilder withWindSpeed(float windSpeed) {
            this.windSpeed = windSpeed;
            return this;
        }

        public ForecastListObjectDtoBuilder withVisibilityInMeters(int visibilityInMeters) {
            this.visibilityInMeters = visibilityInMeters;
            return this;
        }

        public ForecastListObjectDto build() {
            return new ForecastListObjectDto(this);
        }
    }

}
