import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {WeatherDto} from "../interfaces/weather-dto";

@Injectable({
  providedIn: 'root'
})
export class WeatherService {

  constructor(private http: HttpClient) { }

  getWeatherForCity(cityName: string){
    return this.http.get<WeatherDto>("http://localhost:8080/api/weather?city="+cityName);
  }

}
