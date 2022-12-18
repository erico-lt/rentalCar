package model.entites;

public class Invoice {
    private double basicPayment;
    private double tax;

    public Invoice(){        
    }

    public Invoice(double basicPayment, double tax) {
        this.setBasicPayment(basicPayment);
        this.setTax(tax);
    }

    public double totalPayment() {
        return this.getBasicPayment() + this.getTax();
    }
   
    public double getBasicPayment() {
        return basicPayment;
    }

    public void setBasicPayment(double basicPayment) {
        this.basicPayment = basicPayment;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

}