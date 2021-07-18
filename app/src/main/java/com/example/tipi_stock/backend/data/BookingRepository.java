package com.example.tipi_stock.backend.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * Class for interacting with the 'booking Room database'
 */
public class BookingRepository {
    private BookingDao bookingDao;
    private LiveData<List<Booking>> currentBookings;

    public BookingRepository(Application app) {
        BookingDatabase database = BookingDatabase.getDbInstance(app);
        bookingDao = database.bookingDao();
        currentBookings = bookingDao.getAllBookings();
    }

    public LiveData<List<Booking>> getAllBookings() {
        return currentBookings;
    }
}
