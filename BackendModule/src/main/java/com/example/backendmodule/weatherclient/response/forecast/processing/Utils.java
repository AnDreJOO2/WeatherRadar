package com.example.backendmodule.weatherclient.response.forecast.processing;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Utils {

    public static String getFormattedLocalDateTime(long sunset, ZoneOffset timeZone) {
        Instant instant = Instant.ofEpochSecond(sunset);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, timeZone);
        return localDateTime.toString()+timeZone;
    }
}
