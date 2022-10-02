import {Component, OnInit} from '@angular/core';
import * as L from "leaflet";
import {Map} from "leaflet";
import {WeatherService} from "../../services/weather.service";
import {WeatherDto} from "../../interfaces/weather-dto";

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit {
  map: Map;
  marker: L.Marker;

  constructor(private weatherService: WeatherService) {

  }

  ngOnInit(): void {
    this.map = new Map('map').setView([52.23, 21.01], 6); // Warsaw coords
    L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
      maxZoom: 19,
      attribution: '© OpenStreetMap'
    }).addTo(this.map);

    this.weatherService.weatherObject.subscribe(responseData => {
      this.pinPlace(responseData);
    });
  }

  pinPlace(responseData: WeatherDto) {
    this.marker = L.marker([responseData.lat, responseData.lon]).addTo(this.map);
  }

}
