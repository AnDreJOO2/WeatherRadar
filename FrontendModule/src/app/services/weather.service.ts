import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {WeatherDto} from "../interfaces/weather-dto";
import {Subject} from "rxjs";
import {ForecastDto} from "../interfaces/forecast-dto";
import {ForecastSegmentDto} from "../interfaces/forecast-segment-dto";

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

  setDate(forecastTime: string, utcTime: boolean) {

    let substringHour: number | string = Number(forecastTime.substring(0, 2))
    if (substringHour < 10) {
      substringHour = '0' + substringHour;
    }

    let substringMinute: number | string = Number(forecastTime.substring(3, 5))
    if (substringMinute < 10) {
      substringMinute = '0' + substringMinute;
    }

    let substringSeconds: number | string = Number(forecastTime.substring(6, 8))
    if (substringSeconds < 10) {
      substringSeconds = '0' + substringSeconds;
    }

    let substringDay: number | string = Number(forecastTime.substring(9, 11))
    if (substringDay < 10) {
      substringDay = '0' + substringDay;
    }

    let substringMonth: number | string = Number(forecastTime.substring(12, 14))
    if (substringMonth < 10) {
      substringMonth = '0' + substringMonth;
    }
    let substringYear: number | string = Number(forecastTime.substring(15, 19))
    let message = substringHour + ":" + substringMinute + ":" + substringSeconds + " " + substringDay + "-" + substringMonth + "-" + substringYear;
    if (utcTime) {
      message = message + " UTC"
    } else {

      return this.convertOffset()
    }

    return message
  }

  convertOffset() {
    let timeZone = Intl.DateTimeFormat().resolvedOptions().timeZone;
    let offset = new Date().getTimezoneOffset().toString();
    let response: string = ""

    if (offset.substring(0, 1) === '-') {
      response += "+"
    } else {
      response += "-"
    }

    let number = Number(offset.substring(1,));
    number = number / 60
    response += String(number)

    return response + ' ' + timeZone
  }

  getTimeLine(firstElement: ForecastSegmentDto) {
    let day = firstElement.forecastTime.substring(9, 11)
    let month = firstElement.forecastTime.substring(12, 14)
    return day + '-' + month

  }

  countLastIndexForFirstList(firstElement: ForecastSegmentDto): number {
    let date = this.setDate(firstElement.forecastTime, true);
    let hour: number = Number(date.substring(0, 2));
    // possible hours in frame
    // 0
    // 3
    // 6
    // 9
    // 12
    // 15
    // 18
    // 21
    if (hour === 0) {
      return 7
    }
    if (hour === 3) {
      return 6
    }
    if (hour === 6) {
      return 5
    }
    if (hour === 9) {
      return 4
    }
    if (hour === 12) {
      return 3
    }
    if (hour === 15) {
      return 2
    }
    if (hour === 18) {
      return 1
    }
    if (hour === 21) {
      return 0
    }
    return 0
  }

}
