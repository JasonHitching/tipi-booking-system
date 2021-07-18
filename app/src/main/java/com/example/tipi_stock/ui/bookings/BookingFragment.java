package com.example.tipi_stock.ui.bookings;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tipi_stock.R;
import com.example.tipi_stock.backend.bookings.BookingViewModel;
import com.example.tipi_stock.backend.bookings.StructureBooking;
import com.example.tipi_stock.backend.data.Booking;

import java.util.ArrayList;
import java.util.List;

public class BookingFragment extends Fragment {

    private static BookingAdapter bookingAdapter;
    private static RecyclerView bookingRecycler;
    private BookingViewModel bookingViewModel;
    View rootView;

    // Required empty constructor
    public BookingFragment() {
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable @org.jetbrains.annotations.Nullable ViewGroup container,
                             @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rootView = inflater.inflate(R.layout.booking_fragment, null);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        bookingRecycler = rootView.findViewById(R.id.booking_recycler);
        bookingAdapter = new BookingAdapter(getActivity());
        bookingRecycler.setHasFixedSize(true);
        bookingRecycler.setAdapter(bookingAdapter);
        bookingRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        bookingViewModel = new ViewModelProvider(this).get(BookingViewModel.class);

        // Add a live data observer
        bookingViewModel.getAllBookings().observe(this, bookings -> bookingAdapter.setBookings(bookings));

    }

}