import {Component, OnInit} from '@angular/core';
import {WeatherService} from "../../services/weather.service";

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

  checkIfCityNameIsEmpty(){
    if(this.cityName !== ""){
      this.getWeatherForCity();
    }
  }

  getWeatherForCity() {
    this.weatherService.getWeatherForCity(this.cityName);
    this.ResetCityInput();
  }

  ResetCityInput() {
    this.cityName = '';
  }

}
