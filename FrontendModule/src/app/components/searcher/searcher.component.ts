import {Component, OnInit} from '@angular/core';
import {WeatherService} from "../../services/weather.service";
import {WeatherDto} from "../../interfaces/weather-dto";

@Component({
  selector: 'app-searcher',
  templateUrl: './searcher.component.html',
  styleUrls: ['./searcher.component.css']
})
export class SearcherComponent implements OnInit {

  cityName: string = '';

  constructor(private weatherService: WeatherService) {
  }

  ngOnInit(): void {
  }

  getWeatherForCity() {
    this.weatherService.getWeatherForCity(this.cityName).subscribe(
      (responseData: WeatherDto) => {
        console.log(responseData)
      }
    );
    this.ResetCityInput();
  }

  ResetCityInput() {
    this.cityName = '';
  }
}
