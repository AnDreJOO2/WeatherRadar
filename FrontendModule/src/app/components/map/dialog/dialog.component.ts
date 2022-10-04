import {Component, Inject, OnInit} from '@angular/core';
import {WeatherDto} from "../../../interfaces/weather-dto";
import {MAT_DIALOG_DATA} from "@angular/material/dialog";
import {WeatherService} from "../../../services/weather.service";
import {ForecastDto} from "../../../interfaces/forecast-dto";

@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.css']
})
export class DialogComponent implements OnInit {

  private _forecastDto: ForecastDto;

  getForecastDto(): ForecastDto {
    return this._forecastDto;
  }

  getWeatherDto(): WeatherDto {
    return this._weatherDto;
  }

  getWeatherService(): WeatherService {
    return this._weatherService;
  }

  constructor(@Inject(MAT_DIALOG_DATA) private _weatherDto: WeatherDto, private _weatherService: WeatherService) {

  }

  ngOnInit(): void {
  }

  getForecast() {
    this._weatherService.getForecastForCoords(this.getWeatherDto().lat, this.getWeatherDto().lon).subscribe(
      responseData => {
        this._forecastDto = responseData;
      }
    )

  }

}
