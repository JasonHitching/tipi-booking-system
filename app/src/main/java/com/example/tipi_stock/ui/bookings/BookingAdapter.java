package com.example.tipi_stock.ui.bookings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tipi_stock.R;

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.ViewHolder> {

    private String[] data;

    public BookingAdapter(String[] data) {
        this.data = data;
    }



    @Override
    public void onBindViewHolder(@NonNull BookingAdapter.ViewHolder holder, int position) {
        holder.setRowData(data[position]);
    }

    /**
     * Accessor for obtaining the number of elements
     * @return size of dataset
     */
    @Override
    public int getItemCount() {
        return data.length;
    }

    /**
     * ViewHolder class provides a wrapper for around a View, contains layout for individual
     * items in the list
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView bookingTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Obtain the required view from recycler_row.xml
            bookingTextView = itemView.findViewById(R.id.booking_card_text);
        }

        public void setRowData(String text) {
            bookingTextView.setText(text);
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
