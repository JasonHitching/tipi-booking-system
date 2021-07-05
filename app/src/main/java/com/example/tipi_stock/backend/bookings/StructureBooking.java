package com.example.tipi_stock.backend.bookings;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class StructureBooking {

    // Instance fields
    private String structureType, customerFirstName, customerLastName;
    private double cost;
    private LocalDate bookingDate;
    private int noOfDays;

    /**
     * Structure booking class constructor
     * @param structureType desired structure type
     * @param customerFirstName customers first name
     * @param customerLastName customers last name
     * @param cost price of the booking
     * @param bookingDate date of the booking
     * @param noOfDays number of days the structure will be hired for
     */
    public StructureBooking(String structureType, String customerFirstName, String customerLastName,
                            double cost, LocalDate bookingDate, int noOfDays) {
        this.structureType = structureType;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.cost = cost;
        this.bookingDate = bookingDate;
        this.noOfDays = noOfDays;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(int noOfDays) {
        this.noOfDays = noOfDays;
    }

    public String getStructureType() {
        return structureType;
    }

    public void setStructureType(String structureType) {
        this.structureType = structureType;
    }

}
