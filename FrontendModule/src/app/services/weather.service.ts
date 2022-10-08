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
    let date = new Date(forecastTime);
    if (utcTime) {
      let utcSeconds: number | string = date.getUTCSeconds()
      if (utcSeconds < 10) {
        utcSeconds = '0' + utcSeconds;
      }

      let utcMinutes: number | string = date.getUTCMinutes()
      if (utcMinutes < 10) {
        utcMinutes = '0' + utcMinutes;
      }

      let utcHours: number | string = date.getUTCHours()
      if (utcHours < 10) {
        utcHours = '0' + utcHours;
      }

      let utcDay: number | string = date.getUTCDate();
      if (utcDay < 10) {
        utcDay = '0' + utcDay;
      }

      let utcMonth: number | string = date.getUTCMonth() + 1;
      if (utcMonth < 10) {
        utcMonth = '0' + utcMonth;
      }

      let utcYear: number | string = date.getUTCFullYear();
      return utcHours + ':' + utcMinutes + ':' + utcSeconds + ' ' + utcDay + '-' + utcMonth + '-' + utcYear + ' UTC';

    } else {

      let timeZone = Intl.DateTimeFormat().resolvedOptions().timeZone;
      let localSeconds: number | string = date.getSeconds()
      if (localSeconds < 10) {
        localSeconds = '0' + localSeconds;
      }

      let localMinutes: number | string = date.getMinutes()
      if (localMinutes < 10) {
        localMinutes = '0' + localMinutes;
      }

      let localHours: number | string = date.getHours()
      if (localHours < 10) {
        localHours = '0' + localHours;
      }

      let localDay: number | string = date.getDate();
      if (localDay < 10) {
        localDay = '0' + localDay;
      }

      let localMonth: number | string = date.getMonth() + 1;
      if (localMonth < 10) {
        localMonth = '0' + localMonth;
      }

      let localYear: number | string = date.getFullYear();
      return localHours + ':' + localMinutes + ':' + localSeconds + ' ' + localDay + '-' + localMonth + '-' + localYear + ' ' + timeZone;
    }
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
