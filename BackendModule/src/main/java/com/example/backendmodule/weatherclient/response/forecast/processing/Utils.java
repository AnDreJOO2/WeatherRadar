package com.example.backendmodule.weatherclient.response.forecast.processing;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class Utils {

    public static String getFormattedLocalDateTime(long sunset, ZoneOffset timeZone) {
        Instant instant = Instant.ofEpochSecond(sunset);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, timeZone);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
        return localDateTime.format(formatter) + timeZone;
    }
}
