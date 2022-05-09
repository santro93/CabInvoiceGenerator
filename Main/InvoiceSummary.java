package com.bridgelabz;

public class InvoiceSummary {
    private int numOfRiders;
    private double totalFare;
    private double avarage;

    public InvoiceSummary(int numOfRiders, double totalFare) {
        this.numOfRiders = numOfRiders;
        this.totalFare = totalFare;
        this.avarage = this.totalFare/this.numOfRiders;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        InvoiceSummary other = (InvoiceSummary) obj;
        return Double.doubleToLongBits(avarage) == Double.doubleToLongBits(other.avarage)
                && numOfRiders == other.numOfRiders
                && Double.doubleToLongBits(totalFare) == Double.doubleToLongBits(other.totalFare);
    }
}