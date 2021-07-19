package com.example.tipi_stock.ui.bookings;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.tipi_stock.backend.bookings.data.Booking;
import com.example.tipi_stock.backend.bookings.data.BookingRepository;

import java.util.List;

/**
 * Class for providing data to the user interface, decouples frontend from backend logic
 * Instances of 'ViewModel' survive configuration changes
 */
public class SharedBookingViewModel extends AndroidViewModel {

    private BookingRepository roomRepo;

    // Current live data of the Booking entities stored in the Room database
    private LiveData<List<Booking>> currentBookings;

    public SharedBookingViewModel(Application app) {
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

    public void createBooking(String structType, String firstName, String lastName,
                                String cost, String startDate, String noOfDays) {
        double costVal = 0.0;
        int numOfDays = 0;

        try {
            costVal = Double.parseDouble(cost);
            numOfDays = Integer.parseInt(noOfDays);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        Booking newBooking = new Booking(structType, firstName, lastName, costVal, startDate, numOfDays);
        roomRepo.insertBooking(newBooking);
    }

}
