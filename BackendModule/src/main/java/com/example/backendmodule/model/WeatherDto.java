package com.example.backendmodule.model;

public class WeatherDto {

    private final String country;
    private final String cityName;
    private final String description;

    private final long sunrise;
    private final long sunset;
    private final int visibilityInMeters;

    private final float temperature;
    private final float perceptibleTemperature;
    private final float minimumTemperature;
    private final float maximumTemperature;
    private final int pressure;
    private final int humidity;

    private final float windSpeed;
    private final float cloudPercentage;

    private WeatherDto(WeatherDtoBuilder builder) {
        this.country = builder.country;
        this.cityName = builder.cityName;
        this.description = builder.description;

        this.sunrise = builder.sunrise;
        this.sunset = builder.sunset;
        this.visibilityInMeters = builder.visibilityInMeters;

        this.temperature = builder.temperature;
        this.perceptibleTemperature = builder.perceptibleTemperature;
        this.minimumTemperature = builder.minimumTemperature;
        this.maximumTemperature = builder.maximumTemperature;
        this.pressure = builder.pressure;
        this.humidity = builder.humidity;

        this.windSpeed = builder.windSpeed;
        this.cloudPercentage = builder.cloudPercentage;
    }

    @Override
    public String toString() {
        return "WeatherDto{" +
                "country='" + country + '\'' +
                ", cityName='" + cityName + '\'' +
                ", description='" + description + '\'' +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                ", visibilityInMeters=" + visibilityInMeters +
                ", temperature=" + temperature +
                ", perceptibleTemperature=" + perceptibleTemperature +
                ", minimumTemperature=" + minimumTemperature +
                ", maximumTemperature=" + maximumTemperature +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", windSpeed=" + windSpeed +
                ", cloudPercentage=" + cloudPercentage +
                '}';
    }

    public String getCountry() {
        return country;
    }

    public String getCityName() {
        return cityName;
    }

    public String getDescription() {
        return description;
    }

    public long getSunrise() {
        return sunrise;
    }

    public long getSunset() {
        return sunset;
    }

    public int getVisibilityInMeters() {
        return visibilityInMeters;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getPerceptibleTemperature() {
        return perceptibleTemperature;
    }

    public float getMinimumTemperature() {
        return minimumTemperature;
    }

    public float getMaximumTemperature() {
        return maximumTemperature;
    }

    public int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public float getCloudPercentage() {
        return cloudPercentage;
    }

    public static class WeatherDtoBuilder {

        private String country;
        private String cityName;
        private String description;

        private long sunrise;
        private long sunset;
        private int visibilityInMeters;

        private float temperature;
        private float perceptibleTemperature;
        private float minimumTemperature;
        private float maximumTemperature;
        private int pressure;
        private int humidity;

        private float windSpeed;
        private float cloudPercentage;

        public WeatherDtoBuilder withCountry(String country) {
            this.country = country;
            return this;
        }

        public WeatherDtoBuilder withCityName(String cityName) {
            this.cityName = cityName;
            return this;
        }

        public WeatherDtoBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public WeatherDtoBuilder withSunrise(long sunrise) {
            this.sunrise = sunrise;
            return this;
        }

        public WeatherDtoBuilder withSunset(long sunset) {
            this.sunset = sunset;
            return this;
        }

        public WeatherDtoBuilder withVisibilityInMeters(int visibilityInMeters) {
            this.visibilityInMeters = visibilityInMeters;
            return this;
        }

        public WeatherDtoBuilder withTemperature(float temperature) {
            this.temperature = temperature;
            return this;
        }

        public WeatherDtoBuilder withPerceptibleTemperature(float perceptibleTemperature) {
            this.perceptibleTemperature = perceptibleTemperature;
            return this;
        }

        public WeatherDtoBuilder withMinimumTemperature(float minimumTemperature) {
            this.minimumTemperature = minimumTemperature;
            return this;
        }

        public WeatherDtoBuilder withMaximumTemperature(float maximumTemperature) {
            this.maximumTemperature = maximumTemperature;
            return this;
        }

        public WeatherDtoBuilder withPressure(int pressure) {
            this.pressure = pressure;
            return this;
        }

        public WeatherDtoBuilder withHumidity(int humidity) {
            this.humidity = humidity;
            return this;
        }

        public WeatherDtoBuilder withWindSpeed(float windSpeed) {
            this.windSpeed = windSpeed;
            return this;
        }

        public WeatherDtoBuilder withCloudPercentage(int cloudPercentage) {
            this.cloudPercentage = cloudPercentage;
            return this;
        }

        public WeatherDto build() {
            return new WeatherDto(this);
        }

    }
}