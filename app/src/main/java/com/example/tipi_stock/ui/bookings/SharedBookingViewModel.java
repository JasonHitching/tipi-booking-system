package com.example.tipi_stock.ui.bookings;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.tipi_stock.backend.bookings.data.Booking;
import com.example.tipi_stock.backend.bookings.data.BookingRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * Class for providing data to the user interface, decouples frontend from backend logic
 * Instances of 'ViewModel' survive configuration changes.
 *
 * Select functionality from Android Jetpack library classes are utilised
 * to achieve some of the required functionality for this class:
 *      https://developer.android.com/reference/android/arch/lifecycle/AndroidViewModel
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

    public void sortNewestFirst() {
        for (int i = 0; i < currentBookings.getValue().size(); i++) {

        }
    }

    /**
     * Method invoked from the booking form fragment to insert a new booking
     * into the relevant booking Room database.
     *
     * @param structType Type of structure for the booking
     * @param firstName Customers first name
     * @param lastName Customers surname
     * @param address Customers address
     * @param cost Total booking cost
     * @param startDate Date that the booking starts
     * @param noOfDays Number of days the structure will be booked for
     */
    public String createBooking(String structType, String firstName, String lastName, String address,
                                String cost, LocalDate startDate, String noOfDays) {

        double costVal = 0.0;
        int numOfDays = 0;

        LocalDate todaysDate = LocalDate.now();

        // Try-catch to prevent program crash if an attempt is made to convert non integer/double
        try {
            costVal = Double.parseDouble(cost);
            numOfDays = Integer.parseInt(noOfDays);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

        if (startDate.isBefore(todaysDate)) {
            System.out.println("nah");
            return "Booking date entered is in the past";
        } else {
            Booking newBooking = new Booking(structType, firstName, lastName, address, costVal, startDate, numOfDays);
            roomRepo.insertBooking(newBooking);
        }
        return "success";
    }

}
