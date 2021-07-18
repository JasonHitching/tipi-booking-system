package com.example.tipi_stock.backend.bookings;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.tipi_stock.backend.data.Booking;
import com.example.tipi_stock.backend.data.BookingRepository;

import java.util.List;

/**
 * Class for providing data to the user interface, decouples frontend from backend logic
 * Instances of 'ViewModel' survive configuration changes
 */
public class BookingViewModel extends AndroidViewModel {

    private BookingRepository roomRepo;

    // Current live data of the Booking entities stored in the Room database
    private LiveData<List<Booking>> currentBookings;

    public BookingViewModel(Application app) {
        super(app);
        roomRepo = new BookingRepository(app);
        currentBookings = roomRepo.getAllBookings();
    }

    public LiveData<List<Booking>> getAllBookings() {
        return currentBookings;
    }
//
//    public void insert(Booking newBooking) {
//        roomRepo.insert(newBooking);
//    }
//
//    public void deleteAll() {
//        roomRepo.deleteAll();
//    }
//
//    public void deleteWord(Booking discardedBooking) {
//        roomRepo.deleteWord(discardedBooking);
//    }

}
