package com.example.tipi_stock.backend.data;



import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDate;

/**
 * Entity model of a structure booking
 */
@Entity
public class BookingEntity {

    @PrimaryKey
    public int id;

    public String structureType;

    public String customerFirstName;

    public String customerLastName;

    public double cost;

    public LocalDate bookingStartDate;

    public int numberOfDays;
}
