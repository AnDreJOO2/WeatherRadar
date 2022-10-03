package com.example.backendmodule.weatherclient.response.forecast;


import java.util.List;

public class ForecastServiceResponseDto {

    private int cod;
    private int cnt;
    private List<ForecastServiceResponseListDto> list;
    private ForecastServiceResponseCityDto city;

    public int getCod() {
        return cod;
    }

    public int getCnt() {
        return cnt;
    }

    public List<ForecastServiceResponseListDto> getList() {
        return list;
    }

    public ForecastServiceResponseCityDto getCity() {
        return city;
    }
}
