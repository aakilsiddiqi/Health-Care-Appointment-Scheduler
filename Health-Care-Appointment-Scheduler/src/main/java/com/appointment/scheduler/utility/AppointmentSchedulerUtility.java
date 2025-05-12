package com.appointment.scheduler.utility;

import com.appointment.scheduler.exception.AppointmentSchedulerException;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class AppointmentSchedulerUtility {

    private static final LocalTime START = LocalTime.of(10, 0);
    private static final LocalTime END = LocalTime.of(20, 0);

    public static boolean isWithinAllowedTime(String timeStr) throws AppointmentSchedulerException {
        String[] parts = timeStr.split("-");
        if (parts.length != 2) {
            return false;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a", Locale.ENGLISH);
        LocalTime startTime = LocalTime.parse(parts[0].trim(), formatter);
        LocalTime endTime = LocalTime.parse(parts[1].trim(), formatter);

        return !startTime.isBefore(START) && !endTime.isAfter(END) && startTime.isBefore(endTime);
    }
}
