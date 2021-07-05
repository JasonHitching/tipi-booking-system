package com.example.tipi_stock.ui.bookings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.tipi_stock.R;
import com.example.tipi_stock.backend.bookings.BookingModel;
import com.example.tipi_stock.backend.bookings.StructureBooking;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BookingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        //Initialise the data to be used in RecyclerView
        BookingAdapter bookingAdapter = new BookingAdapter(obtainBookings());
        RecyclerView bookingRecycler = findViewById(R.id.booking_recycler);
        bookingRecycler.setLayoutManager(new LinearLayoutManager(this));
        bookingRecycler.setHasFixedSize(true);
        bookingRecycler.setAdapter(bookingAdapter);
    }

    public ArrayList obtainBookings() {
        BookingModel bookingModel = new BookingModel();
        ArrayList<StructureBooking> currentBookings = bookingModel.getCurrentBookings();
        return currentBookings;
    }
}