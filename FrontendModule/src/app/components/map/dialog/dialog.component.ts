import {Component, Inject, OnInit} from '@angular/core';
import {WeatherDto} from "../../../interfaces/weather-dto";
import {MAT_DIALOG_DATA} from "@angular/material/dialog";

@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.css']
})
export class DialogComponent implements OnInit {



  weatherDto(): WeatherDto {
    return this._weatherDto;
  }

  constructor(@Inject(MAT_DIALOG_DATA) private _weatherDto: WeatherDto) {
  }

  ngOnInit(): void {
  }

}
