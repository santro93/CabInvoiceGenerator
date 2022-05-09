package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CabInvoiceGenerator {
    InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

    @Before
    public void setUp() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTime_ReturnTotalFare(){
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(25, fare, 0.0); // 0.0 is the precesion range
    }

    @Test
    public void givenDistanceAndTime_ReturnMinFare(){
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(5, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_ReturnInvoiceSummary(){
        Ride rides[] = { new Ride(1.1, 1),
                new Ride(10.0, 5),
                new Ride(5.0, 6),
                new Ride(8.9, 1),
                new Ride(9.0, 9) };
        InvoiceSummary fare = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummery = new InvoiceSummary(5, 362);
        Assertions.assertEquals(expectedInvoiceSummery, fare);
    }

    @Test
    public void givenMultipleRides_ReturnInvoice(){
        Ride rides[] = { new Ride(1.1, 1),
                new Ride(10.0, 5),
                new Ride(5.0, 6),
                new Ride(8.9, 1),
                new Ride(9.0, 9) };
        String userID = "Rao";
        InvoiceService invoice = new InvoiceService(userID, rides);
        Assertions.assertNotNull(invoice);
    }

    @Test
    public void givenMultipleRides_ArePremium(){
        double distance = 1;
        int time = 1;
        String RideType = "Premium";
        invoiceGenerator.getRideType(RideType);
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(20, fare, 0.0);
    }
}