package com.example.backendmodule.weatherclient.response.weather;

public class WeatherServiceResponseMainDto {

    private float temp;
    private float feels_like;
    private float temp_min;
    private float temp_max;
    private int pressure;
    private int humidity;

    public float getTemp() {
        return temp;
    }

    public float getFeels_like() {
        return feels_like;
    }

    public float getTemp_min() {
        return temp_min;
    }

    public float getTemp_max() {
        return temp_max;
    }

    public int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

}
