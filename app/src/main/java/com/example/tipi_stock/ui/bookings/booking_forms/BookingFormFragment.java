package com.example.tipi_stock.ui.bookings.booking_forms;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.tipi_stock.R;
import com.example.tipi_stock.ui.bookings.SharedBookingViewModel;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Fragment used to display an XML form for inputting a new structure booking
 *
 * Select functionality from Android Jetpack library classes are utilised
 * to achieve some of the required functionality for this class:
 *     https://developer.android.com/reference/androidx/fragment/app/Fragment
 */
public class BookingFormFragment extends Fragment {

    private View rootView;
    private MaterialDatePicker bookingDateSelector;
    private ImageButton calendarButton;
    private TextInputEditText dateText, structureText, firstNameText, lastNameText, costText, daysText,
                                firstLineAddress, postcode, houseNumber;
    private TextInputLayout dateTextLayout;
    private SharedBookingViewModel bookingViewModel;
    private Button submitButton;

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
        
        // Locate all input fields and assign them to relevant variables
        dateTextLayout = rootView.findViewById(R.id.desired_date);
        dateText = rootView.findViewById(R.id.selected_date);
        structureText = rootView.findViewById(R.id.structure_type_text);
        firstNameText = rootView.findViewById(R.id.customer_first_name);
        lastNameText = rootView.findViewById(R.id.customer_last_name);
        costText = rootView.findViewById(R.id.booking_cost);
        daysText = rootView.findViewById(R.id.num_days_text);
        firstLineAddress = rootView.findViewById(R.id.address_text);
        postcode = rootView.findViewById(R.id.postcode_text);
        houseNumber = rootView.findViewById(R.id.house_number_text);

        // Handle form buttons
        submitButton = rootView.findViewById(R.id.submit_form_button);
        calendarButton = rootView.findViewById(R.id.calander_button);

        // Reference the shared view model for both BookingFormFragment and BookingForm
        bookingViewModel = new ViewModelProvider(requireActivity()).get(SharedBookingViewModel.class);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {

        // Display MaterialDatePicker instance when image button clicked
        calendarButton.setOnClickListener(dateComp -> {
            bookingDateSelector.show(Objects.requireNonNull(getActivity()).getSupportFragmentManager(),
                    "DATE_PICKER");
        });

        // Respond to user selected date input
        bookingDateSelector.addOnPositiveButtonClickListener(selection -> {
            dateText.setText(bookingDateSelector.getHeaderText());
            System.out.println(bookingDateSelector.getHeaderText());
            dateTextLayout.setHint("Selected date");
        });


        // On click listener monitoring the form submit button
        submitButton.setOnClickListener(submit -> {

            // Concatenate customer address values
            String customerAddress = houseNumber.getText().toString() + " - "
                    + firstLineAddress.getText().toString() + " - "
                    + postcode.getText().toString();

            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMM-d-yyyy");
            String replaceCommas = dateText.getText().toString().replaceAll(", ", " ");

            String result = bookingViewModel.createBooking(
                    Objects.requireNonNull(structureText.getText()).toString(),
                    Objects.requireNonNull(firstNameText.getText()).toString(),
                    Objects.requireNonNull(lastNameText.getText()).toString(),
                    customerAddress,
                    Objects.requireNonNull(costText.getText()).toString(),
                    LocalDate.parse(replaceCommas.replace(" ", "-"), dateFormatter),
                    Objects.requireNonNull(daysText.getText()).toString());

            // If the booking wasn't a success, display a dialog window the the reason
            if (!result.equals("success")) {
                // Obtain the view context to be used to display the dialog
                Context viewContext = view.getRootView().getContext();

                AlertDialog.Builder incorrectInput = new AlertDialog.Builder(viewContext);
                incorrectInput.setMessage(result);
                incorrectInput.setPositiveButton("Okay", (dialogInterface, i) -> {});
                incorrectInput.create().show();
            } else {
                NavHostFragment.findNavController(this).popBackStack();
            }
        });
    }
}
