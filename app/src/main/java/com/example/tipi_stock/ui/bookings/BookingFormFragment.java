package com.example.tipi_stock.ui.bookings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tipi_stock.R;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class BookingFormFragment extends Fragment {

    View rootView;
    MaterialDatePicker bookingDateSelector;
    ImageButton calendarButton;
    TextInputEditText dateText;
    TextInputLayout dateTextLayout;



    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable @org.jetbrains.annotations.Nullable ViewGroup container,
                             @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rootView = inflater.inflate(R.layout.booking_form_fragment, null);

        bookingDateSelector = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select booking date")
                .build();

        calendarButton = rootView.findViewById(R.id.calander_button);
        dateText = rootView.findViewById(R.id.selected_date);
        dateTextLayout = rootView.findViewById(R.id.desired_date);


        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {

        // Display MaterialDatePicker instance when image button clicked
        calendarButton.setOnClickListener(view1 -> {
            bookingDateSelector.show(Objects.requireNonNull(getActivity()).getSupportFragmentManager(),
                    "DATE_PICKER");
        });

        // Respond to user selected date input
        bookingDateSelector.addOnPositiveButtonClickListener(selection -> {
            dateText.setText(bookingDateSelector.getHeaderText());
            dateTextLayout.setHint("Selected date");
        });
    }
}
