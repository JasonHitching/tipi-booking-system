package com.example.tipi_stock.ui.bookings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tipi_stock.R;

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.ViewHolder> {

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.recycler_row, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BookingAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView customerTextView;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            // Obtain the required view from recycler_row.xml
            customerTextView = itemView.findViewById(R.id.customerNameView);
        }

        public void setCustomerName(String text) {
            customerTextView.setText(text);
        }
    }
}
