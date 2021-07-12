package com.example.tipi_stock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tipi_stock.ui.bookings.BookingFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // condition used to only render each fragment once
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragmentContainerView, BookingFragment.class, null)
                    .commit();
        }
    }
}