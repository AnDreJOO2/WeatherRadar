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
  markers: L.Marker[] = [];

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
    if (this.markers.length > 0) {
      this.clearPin();
    }

    let marker = L.marker([responseData.lat, responseData.lon])
      .bindPopup('Wind speed: ' + responseData.windSpeed + "</br>" +
        'minimumTemperature: ' + responseData.minimumTemperature + "</br>" +
        'maximumTemperature: ' + responseData.maximumTemperature + "</br>" +
        'cloudPercentage: ' + responseData.cloudPercentage + "</br>" +
        'pressure: ' + responseData.pressure + "</br>" +
        'humidity: ' + responseData.humidity + "</br>")
      .openPopup()
      .addTo(this.map);

    this.markers.push(marker);
    this.map.setView([marker.getLatLng().lat, marker.getLatLng().lng], 10);
  }

  clearPin() {
    this.map.removeLayer(this.markers[this.markers.length - 1])
  }


}
