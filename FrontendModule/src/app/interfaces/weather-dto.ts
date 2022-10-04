export interface WeatherDto {

  lon: number;
  lat: number;
  country: string;
  cityName: string;
  description: string;
  sunrise: string;
  sunset: string;
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
