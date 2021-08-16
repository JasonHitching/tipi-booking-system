package com.example.tipi_stock.ui.bookings;

import junit.framework.TestCase;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.test.core.app.ApplicationProvider;

import com.example.tipi_stock.backend.bookings.data.Booking;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SharedBookingViewModelTest extends TestCase {

    SharedBookingViewModel viewModel = new SharedBookingViewModel(
            ApplicationProvider.getApplicationContext());
    LiveData<List<Booking>> dummyBookings = new LiveData<List<Booking>>() {
        
    }

    @Override
    protected final void setUp() throws Exception {
        Booking stretchBooking = new Booking("Stetch Tent",
                "Joe", "Copping",
                "1 Pleasant Drive GT53DP",800,
                LocalDate.of(2021, 8, 1), 5);
        dummyBookings.getValue().add(stretchBooking);

        Booking tipiBooking = new Booking( "Tipi",
                "Jason", "Hitching",
                "76 Inway Drive KL25TP", 233,
                LocalDate.of(2021, 6, 3), 10);
        dummyBookings.getValue().add(tipiBooking);
    }

    public void testSortDateAscending() {
        viewModel.setCurrentBookings(dummyBookings);
    }

    public void testSortDateDescending() {
    }

    public void testUpdateBooking() {
    }
}