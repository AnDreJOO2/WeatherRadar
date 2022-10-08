import {Component, Inject, OnInit} from '@angular/core';
import {WeatherDto} from "../../../interfaces/weather-dto";
import {MAT_DIALOG_DATA} from "@angular/material/dialog";
import {WeatherService} from "../../../services/weather.service";
import {ForecastDto} from "../../../interfaces/forecast-dto";
import {ForecastSegmentDto} from "../../../interfaces/forecast-segment-dto";

@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.css']
})
export class DialogComponent implements OnInit {

  selectedOption: number;
  private _forecastDto: ForecastDto;

  lastFrameIndex: number;
  listOfForecastSegments: ForecastSegmentDto[][] = []
  loading: boolean;

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
      this.loading = true;
      new Promise((resolve) => {
        this.weatherService.getForecastForCoords(this.getWeatherDto().lat, this.getWeatherDto().lon).subscribe(
          responseData => {
            responseData.sunrise = this.weatherService.setDate(responseData.sunrise, true)
            responseData.sunset = this.weatherService.setDate(responseData.sunset, true)
            this._forecastDto = responseData;
          }
        );
        setTimeout(() => {
          resolve(this.setLastFrameIndex())
        }, 500)
      })
    }
  }

  setLastFrameIndex() {
    new Promise((resolve) => {
      this.lastFrameIndex = this.getWeatherService().countLastIndexForFirstList(this.getForecastDto().list[0])
      setTimeout(() => {
        resolve(this.setListOfForecastSegments(this.lastFrameIndex))
      }, 500)
    })

  }

  private setListOfForecastSegments(lastFrameIndex: number) {

    let list = this.getForecastDto().list;
    let nextStartIndex = lastFrameIndex + 1;
    this.listOfForecastSegments.push(list.slice(0, nextStartIndex))

    let left = 39 - nextStartIndex;
    let end = false;
    while (!end) {

      if (left < 8) {
        end = true;
      }
      this.listOfForecastSegments.push(list.slice(nextStartIndex, nextStartIndex + 8))
      nextStartIndex += 8
      left -= 8
    }
    if (left > 0 && left < 8) {
      this.listOfForecastSegments.push(list.slice(nextStartIndex, 39))
    }

    this.loading = false;
  }

}
