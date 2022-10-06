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

  selectedOption: number;
  private _forecastDto: ForecastDto;

  getHeader() {
    let header: string;

    if (this.selectedOption === 0) {
      header = 'Weather for '
    } else {
      header = 'Forecast for '
    }

    if (this.getWeatherDto().cityName !== '') {
      header += this.getWeatherDto().cityName;
    } else {
      header += this.getWeatherDto().lat;
      header += ' | ';
      header += this.getWeatherDto().lon;
    }

    return header;
  }

  getForecastDto(): ForecastDto {
    return this._forecastDto;
  }

  getWeatherDto(): WeatherDto {
    return this._weatherDto;
  }

  getWeatherService(): WeatherService {
    return this.weatherService;
  }

  constructor(@Inject(MAT_DIALOG_DATA) private _weatherDto: WeatherDto, private weatherService: WeatherService) {

  }

  ngOnInit(): void {
    this.selectedOption = 0;
  }

  getForecast() {
    if (this.getForecastDto() === undefined) {
      this.weatherService.getForecastForCoords(this.getWeatherDto().lat, this.getWeatherDto().lon).subscribe(
        responseData => {
          responseData.sunrise = this.weatherService.setDate(responseData.sunrise, true)
          responseData.sunset = this.weatherService.setDate(responseData.sunset, true)
          this._forecastDto = responseData;
        }
      )
    }

  }

}
