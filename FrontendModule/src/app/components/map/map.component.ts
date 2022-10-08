import {Component, OnInit} from '@angular/core';
import * as L from "leaflet";
import {Map} from "leaflet";
import {WeatherService} from "../../services/weather.service";
import {WeatherDto} from "../../interfaces/weather-dto";
import {DialogComponent} from "./dialog/dialog.component";
import {MatDialog} from '@angular/material/dialog';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit {
  map: Map;
  markers: L.Marker[] = [];

  constructor(private weatherService: WeatherService, public dialog: MatDialog) {

  }

  ngOnInit(): void {
    this.map = new Map('map').setView([52.23, 21.01], 6); // Warsaw coords
    L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
      maxZoom: 19,
      attribution: '© OpenStreetMap'
    }).addTo(this.map);

    this.map.doubleClickZoom.disable();

    this.weatherService.weatherObject.subscribe(responseData => {
      this.pinPlace(responseData);
    });

    this.map.on(
      "dblclick", data => this.weatherService.getWeatherForCoords(data.latlng.lat, data.latlng.lng).subscribe(
        responseData => {
          responseData.sunrise = this.weatherService.setDate(responseData.sunrise, true)
          responseData.sunset = this.weatherService.setDate(responseData.sunset, true)
          this.pinPlace(responseData)
        }
      ))

  }

  pinPlace(responseData: WeatherDto) {
    if (this.markers.length > 0) {
      this.clearPin();
    }

    let marker = L.marker([responseData.lat, responseData.lon])
      .openPopup()
      .on("click", () => this.openDialog(responseData))
      .addTo(this.map);

    this.markers.push(marker);
    this.map.setView([marker.getLatLng().lat, marker.getLatLng().lng], 10);

  }

  clearPin() {
    this.map.removeLayer(this.markers[this.markers.length - 1])
  }

  openDialog(responseData: WeatherDto) {
    let dialog = this.dialog.open(DialogComponent, {
      height: '600px',
      width: '800px',
      data: responseData,
      panelClass: 'dialog-main'
    });


  }

}

