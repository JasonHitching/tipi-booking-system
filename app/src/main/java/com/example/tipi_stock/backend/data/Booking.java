package com.example.tipi_stock.backend.data;



import androidx.room.Entity;
import androidx.room.PrimaryKey;

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

    public String bookingStartDate;

    public int numberOfDays;

    public Booking(int id, String structureType, String customerFirstName, String customerLastName, double cost, String bookingStartDate, int numberOfDays) {
        this.id = id;
        this.structureType = structureType;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.cost = cost;
        this.bookingStartDate = bookingStartDate;
        this.numberOfDays = numberOfDays;
    }

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

    public String getBookingStartDate() {
        return bookingStartDate;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }
}
