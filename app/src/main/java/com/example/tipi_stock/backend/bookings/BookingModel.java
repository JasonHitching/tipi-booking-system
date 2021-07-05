package com.example.tipi_stock.backend.bookings;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

public class BookingModel {

    private ArrayList<StructureBooking> currentBookings;

    public BookingModel() {
        currentBookings = new ArrayList<>();
        populateData();
    }

    public ArrayList<StructureBooking> getCurrentBookings() {
        return currentBookings;
    }

    public void makeBooking() {
        // are structures available on the desired date?

        // are crew members available at the time and date of the desired booking?
    }

    /**
     * Getter for number of bookings
     * @return number of bookings
     */
    public int getNumOfBookings() {
        return currentBookings.size();
    }

    /**
     * Temp method for populating test data (plans to delegate into cloud)
     */
    public void populateData() {
        StructureBooking tipiBooking1 = new StructureBooking("Tipi",
                "Jason", "Hitching", 1000,
                LocalDate.of(2021, Month.AUGUST, 9), 5);
        currentBookings.add(tipiBooking1);

        StructureBooking marqueeBooking = new StructureBooking("Marquee",
                "James", "Blunt", 2500,
                LocalDate.of(2021, Month.JUNE, 9), 5);
        currentBookings.add(marqueeBooking);

        StructureBooking stretchBooking = new StructureBooking("Stretch Tent",
                "Helen", "Copping", 800,
                LocalDate.of(2021, Month.NOVEMBER, 23), 5);
        currentBookings.add(stretchBooking);
    }
}
