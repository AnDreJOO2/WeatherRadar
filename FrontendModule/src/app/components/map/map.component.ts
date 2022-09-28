import {Component, OnInit} from '@angular/core';
import * as L from "leaflet";
import {Map} from "leaflet";

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit {

  constructor() {

  }

  ngOnInit(): void {
    const map = new Map('map').setView([52.23, 21.01], 6); // Warsaw coords
    L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
      maxZoom: 19,
      attribution: '© OpenStreetMap'
    }).addTo(map);
  }

}
