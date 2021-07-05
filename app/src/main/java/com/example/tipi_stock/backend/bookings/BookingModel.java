package com.example.tipi_stock.backend.bookings;

import java.util.ArrayList;

public class BookingModel {

    private ArrayList<StructureBooking> currentBookings;

    public BookingModel() {
        currentBookings = new ArrayList<>();
    }

    public ArrayList<StructureBooking> getCurrentBookings() {
        return currentBookings;
    }

    public void makeBooking() {
        // are structures available on the desired date?

        // are crew members available at the time and date of the desired booking?
    }
}
