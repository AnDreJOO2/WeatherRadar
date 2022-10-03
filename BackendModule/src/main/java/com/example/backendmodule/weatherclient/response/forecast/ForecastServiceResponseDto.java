package com.example.backendmodule.weatherclient.response.forecast;


import java.util.ArrayList;

public class ForecastServiceResponseDto {

    private int cod;
    private int cnt;
    private ArrayList<ForecastServiceResponseListDto> list;
    private ForecastServiceResponseCityDto city;

    public int getCod() {
        return cod;
    }

    public int getCnt() {
        return cnt;
    }

    public ArrayList<ForecastServiceResponseListDto> getList() {
        return list;
    }

    public ForecastServiceResponseCityDto getCity() {
        return city;
    }
}
