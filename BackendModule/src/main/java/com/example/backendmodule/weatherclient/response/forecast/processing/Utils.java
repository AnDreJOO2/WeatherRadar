package com.example.backendmodule.weatherclient.response.forecast.processing;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {

    public static String getFormattedLocalDateTime(long sunset, String timeZone) {
        Instant instant = Instant.ofEpochSecond(sunset);

        ZonedDateTime utc = instant.atZone(ZoneId.of(timeZone));
        LocalDateTime localDateTime = utc.toLocalDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss / dd-MM-yyyy");

        return localDateTime.format(formatter)+ timeZone;
    }
}
