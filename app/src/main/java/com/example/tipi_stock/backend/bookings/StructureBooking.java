package com.example.tipi_stock.backend.bookings;

import java.time.LocalDate;

public class StructureBooking {

    // Instance fields
    private String structureType, customerFirstName, customerLastName;
    private double cost;
    private LocalDate bookingStartDate, bookingEndDate;
    private int noOfDays;

    /**
     * Structure booking class constructor
     * @param structureType desired structure type
     * @param customerFirstName customers first name
     * @param customerLastName customers last name
     * @param cost price of the booking
     * @param bookingStartDate date of the booking
     * @param noOfDays number of days the structure will be hired for
     */
    public StructureBooking(String structureType, String customerFirstName, String customerLastName,
                            double cost, LocalDate bookingStartDate, LocalDate bookingEndDate, int noOfDays) {
        this.structureType = structureType;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.cost = cost;
        this.bookingStartDate = bookingStartDate;
        this.bookingEndDate = bookingEndDate;
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

    public LocalDate getBookingStartDate() {
        return bookingStartDate;
    }

    public void setBookingStartDate(LocalDate bookingStartDate) {
        this.bookingStartDate = bookingStartDate;
    }

    public LocalDate getBookingEndDate() {
        return bookingEndDate;
    }

    public void setBookingEndDate(LocalDate bookingEndDate) {
        this.bookingEndDate = bookingEndDate;
    }

    public String getStructureType() {
        return structureType;
    }

    public void setStructureType(String structureType) {
        this.structureType = structureType;
    }

}
