package com.example.tipi_stock.backend.bookings;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;


public class DeleteDialogFragment extends DialogFragment {

    public static String TAG = "DeleteDialogFragment";

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return new AlertDialog.Builder(requireContext())
                .setMessage("Do you really want to delete this booking?")
                .setPositiveButton("Delete", (dialogInterface, i) -> {
                    System.out.println("Deleted");
                })
                .setNegativeButton("Cancel", (dialogInterface, i) -> {
                    System.out.println("Not deleted");
                })
                .create();
    }

    //    @NonNull
//    @Override
//    public Dialog onCreateDialog(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
//        AlertDialog.Builder buildDialog = new AlertDialog.Builder(getActivity());
//        buildDialog.setMessage("Do you really want to delete this booking?")
//                .setPositiveButton("Delete", (dialogInterface, i) -> {
//                    System.out.println("Deleted");
//                })
//                .setNegativeButton("Cancel", (dialogInterface, i) -> {
//                    System.out.println("Not deleted");
//                });
//        return buildDialog.create();
//    }


}
