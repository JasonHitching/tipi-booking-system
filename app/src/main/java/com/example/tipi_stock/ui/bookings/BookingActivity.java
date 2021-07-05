package com.example.tipi_stock.ui.bookings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.tipi_stock.R;

public class BookingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        //Initialise the data to be used in RecyclerView
        String[] data = initialiseDummyData();

        BookingAdapter bookingAdapter = new BookingAdapter(data);
        RecyclerView bookingRecycler = findViewById(R.id.booking_recycler);
        bookingRecycler.setLayoutManager(new LinearLayoutManager(this));
        bookingRecycler.setHasFixedSize(true);
        bookingRecycler.setAdapter(bookingAdapter);
    }

    /**
     * Generate dummy data for the recycler view
     * @return string array of data
     */
    private String[] initialiseDummyData() {
        String[] dataset = new String[10];

        for (int i = 0; i < dataset.length; i++) {
            dataset[i] = "This is position " + i;
        }

        return dataset;
    }
}