package com.example.tipi_stock.ui.bookings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tipi_stock.R;
import com.example.tipi_stock.backend.bookings.StructureBooking;

import java.util.ArrayList;

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.ViewHolder> {

    private ArrayList<StructureBooking> bookingData;

    public BookingAdapter(ArrayList<StructureBooking> bookingData) {
        this.bookingData = bookingData;
    }

    @Override
    public void onBindViewHolder(@NonNull BookingAdapter.ViewHolder holder, int position) {
        holder.setRowData(bookingData.get(position));
    }

    /**
     * Accessor for obtaining the number of elements
     * @return size of dataset
     */
    @Override
    public int getItemCount() {
        return bookingData.size();
    }

    /**
     * ViewHolder class provides a wrapper for around a View, contains layout for individual
     * items in the list
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView bookingTextView;
        TextView customerTextView;
        TextView dateStartTextView;
        TextView dateEndTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Obtain the required view from recycler_row.xml
            bookingTextView = itemView.findViewById(R.id.structure_type_text);
            customerTextView = itemView.findViewById(R.id.customer_text);
            dateStartTextView = itemView.findViewById(R.id.start_date_text);
            dateEndTextView = itemView.findViewById(R.id.end_date_text);
        }

        /**
         * Set the booking item data
         * @param booking booking object passed when a ViewHolder binds
         */
        public void setRowData(StructureBooking booking) {
            bookingTextView.setText(booking.getStructureType());
            customerTextView.setText("Customer name: " + booking.getCustomerFirstName() +
                    " " + booking.getCustomerLastName());
            dateStartTextView.setText(booking.getBookingStartDate().toString() + " - ");
            dateEndTextView.setText(booking.getBookingEndDate().toString());
        }
    }

    /**
     * Overridden method for creating and initialising a ViewHolder and related View
     *
     * @param parent new views added to the parent ViewGroup
     * @param viewType view type of new view
     * @return
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.booking_card_view, parent, false);
        ViewHolder holder = new ViewHolder(itemView);
        return holder;
    }
}
