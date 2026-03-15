package com.example.recipeapp.ui.schedule;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public final class ScheduleDateUtils {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private ScheduleDateUtils() {
    }

    public static String changeMillisToDateString(Long millis) {
        LocalDate date = millis == null ? LocalDate.now() : toLocalDate(millis);
        return date.format(DATE_FORMATTER);
    }

    public static LocalDate toLocalDate(long millis) {
        return Instant.ofEpochMilli(millis).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static long toMillis(LocalDate date) {
        return date.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static List<LocalDate> getWeekAround(LocalDate selectedDate) {
        LocalDate currentDate = LocalDate.now();
        if (selectedDate.isAfter(currentDate.minusDays(1))) {
            return range(selectedDate.minusDays(2), selectedDate.plusDays(4));
        }
        if (selectedDate.isAfter(currentDate.minusDays(2))) {
            return range(selectedDate.minusDays(1), selectedDate.plusDays(5));
        }
        return range(selectedDate, selectedDate.plusDays(6));
    }

    public static List<LocalDate> range(LocalDate start, LocalDate endInclusive) {
        List<LocalDate> dates = new ArrayList<>();
        LocalDate cursor = start;
        while (!cursor.isAfter(endInclusive)) {
            dates.add(cursor);
            cursor = cursor.plusDays(1);
        }
        return dates;
    }
}
