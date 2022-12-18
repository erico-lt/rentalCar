package model.services;

import java.time.Duration;

import model.entites.CarRental;
import model.entites.Invoice;

public class RentalServices {
    private double pricePerHours;
    private double pricePerDay;

    private TaxServices taxServices;

    public RentalServices(double pricePerHours, double pricePerDay, TaxServices taxService) {
        this.setPricePerHours(pricePerHours);
        this.setPricePerDay(pricePerDay);
        this.setTaxServices(taxService);
    }

    public void processInvoice (CarRental carRental) {
        double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes(); 
        double hours = minutes / 60.0;
        double basicPayment;
        if(hours <= 12.0) {
            basicPayment = pricePerHours * Math.ceil(hours); 
        } else {
            basicPayment = pricePerDay * Math.ceil(hours / 24);
        }                
        carRental.setInvoice(new Invoice(basicPayment, this.getTaxServices().tax(basicPayment)));
    }

    public double getPricePerHours() {
        return pricePerHours;
    }

    public void setPricePerHours(double pricePerHours) {
        this.pricePerHours = pricePerHours;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public TaxServices getTaxServices() {
        return taxServices;
    }

    public void setTaxServices(TaxServices taxServices) {
        this.taxServices = taxServices;
    }

}
