package com.bridgelabz;

public class InvoiceService {
    private static  String invoice ;
    private String userID;
    private Ride[] rides;
    private InvoiceSummary totalfare;

    public InvoiceService(String userID, Ride[] rides) {
        this.userID = userID;
        this.rides = rides;
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        this.totalfare = invoiceGenerator.calculateFare(rides);
        this.invoice = userID+", "+rides+", "+totalfare;
    }
}