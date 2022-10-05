export interface ForecastSegmentDto {

  forecastTime: string;
  minimumTemperature: number;
  maximumTemperature: number;
  temperature: number;
  perceptibleTemperature: number;
  pressure: number;
  humidity: number;
  description: string;
  cloudPercentage: 0,
  windSpeed: number;
  visibilityInMeters: number;
}
