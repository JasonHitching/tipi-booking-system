package com.example.tipi_stock.backend.bookings.data;

import androidx.room.TypeConverter;

import java.util.Date;

/**
 * Class for converting a Long value to a Date and vice versa
 * The Room persistence library knows how to persist Long objects but not Date objects
 */
public class DateConverter {

    /**
     * Type converter for converting a timestamp to a Date object
     * @param timestamp
     * @return a new Date object
     */
    @TypeConverter
    public static Date convertFromTimestamp(Long timestamp) {
        if (timestamp == null) {
            return null;
        } else {
            return new Date(timestamp);
        }
    }

    /**
     * Type converter for converting a date to a timestamp
     * @param dateToConvert
     * @return converted date
     */
    @TypeConverter
    public static Long convertDateToTimestamp(Date dateToConvert) {
        if (dateToConvert == null) {
            return null;
        } else {
            return dateToConvert.getTime();
        }
    }
}
