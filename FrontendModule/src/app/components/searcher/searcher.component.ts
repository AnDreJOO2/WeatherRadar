import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-searcher',
  templateUrl: './searcher.component.html',
  styleUrls: ['./searcher.component.css']
})
export class SearcherComponent implements OnInit {

  cityName: string = '';

  constructor(private http: HttpClient) {
  }

  ngOnInit(): void {
  }

  getWeatherForCity() {
    let city = new URLSearchParams();
    city.append("city", this.cityName)
    this.http.get("http://localhost:8080/api/weather?city="+this.cityName)
      .subscribe(cityWeather =>{
        console.log(cityWeather)
      });
  }

  ResetCityInput() {
    this.cityName = '';
  }
}
