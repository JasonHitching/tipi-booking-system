package com.example.tipi_stock.backend.data;



import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDate;

/**
 * Entity model of a structure booking
 */
@Entity(tableName = "booking_table")
public class Booking {

    @PrimaryKey
    public int id;

    public String structureType;

    public String customerFirstName;

    public String customerLastName;

    public double cost;

    public LocalDate bookingStartDate;

    public int numberOfDays;

    public int getId() {
        return id;
    }

    public String getStructureType() {
        return structureType;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public double getCost() {
        return cost;
    }

    public LocalDate getBookingStartDate() {
        return bookingStartDate;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }
}
