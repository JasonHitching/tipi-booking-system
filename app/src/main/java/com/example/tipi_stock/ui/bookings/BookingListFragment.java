package com.example.tipi_stock.ui.bookings;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tipi_stock.R;

/**
 * A fragment to be used for housing a booking RecyclerView
 */
public class BookingListFragment extends Fragment {

    public BookingListFragment() {
        // Required empty public constructor
    }

    public static BookingListFragment newInstance(String param1, String param2) {
        BookingListFragment fragment = new BookingListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate desired xml layout
        return inflater.inflate(R.layout.fragment_booking_list, container, false);
    }
}