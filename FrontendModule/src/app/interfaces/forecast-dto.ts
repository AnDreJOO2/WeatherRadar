import {ForecastSegmentDto} from "./forecast-segment-dto";

export interface ForecastDto {

  cod: number;
  cnt: number;
  list: ForecastSegmentDto[];
  country: string;
  cityName: string;
  lat: number;
  lon: number;
  sunrise: string;
  sunset: string;
}
