export interface WeatherDto {

  lon: number;
  lat: number;
  country: string;
  cityName: string;
  description: string;
  sunrise: Date;
  sunset: Date;
  visibilityInMeters: number;
  temperature: number;
  perceptibleTemperature: number;
  minimumTemperature: number;
  maximumTemperature: number;
  pressure: number;
  humidity: number;
  windSpeed: number;
  cloudPercentage: number;

}
