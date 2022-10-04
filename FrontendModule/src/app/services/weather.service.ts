import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {WeatherDto} from "../interfaces/weather-dto";
import {Subject} from "rxjs";
import {ForecastDto} from "../interfaces/forecast-dto";

@Injectable({
  providedIn: 'root'
})
export class WeatherService {

  weatherObject = new Subject<WeatherDto>();

  constructor(private http: HttpClient) {
  }

  getWeatherForCity(cityName: string) {
    let weatherDtoObservable = this.http.get<WeatherDto>("http://localhost:8080/api/weather?city=" + cityName);
    weatherDtoObservable.subscribe(responseData => {
      this.sendDataToMapComponent(responseData);
    })

  }

  getWeatherForCoords(lat: number, lon: number) {
    return this.http.get<WeatherDto>("http://localhost:8080/api/weather/coords?lat=" + lat + "&lon=" + lon);
  }

  getForecastForCoords(lat: number, lon: number) {
    return this.http.get<ForecastDto>("http://localhost:8080/api/forecast?lat=" + lat + "&lon=" + lon);
  }

  sendDataToMapComponent(weatherDtoObservable: WeatherDto) {
    this.weatherObject.next(weatherDtoObservable);
  }


}
