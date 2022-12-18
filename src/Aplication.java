import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entites.CarRental;
import model.entites.Vehicle;
import model.services.BrazilTaxServices;
import model.services.RentalServices;

public class Aplication {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner  input = new Scanner(System.in);
        DateTimeFormatter ftm = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        
        System.out.println("Entre com os dados do aluguel");
        System.out.print("Modelo do carro: ");
        String carModel = input.nextLine();
        System.out.print("Retirada (ss/MM/yyyy hh:mm): ");
        LocalDateTime start = LocalDateTime.parse(input.nextLine(), ftm);
        System.out.print("Retorno (ss/MM/yyyy hh:mm): ");
        LocalDateTime finish = LocalDateTime.parse(input.nextLine(), ftm);
        System.out.print("Entre com o preço por hora: ");
        double pricePerHours = input.nextDouble();
        System.out.print("Entre com o preço por dia: ");
        double pricePerDay = input.nextDouble();

        CarRental cr = new CarRental(start, finish, new Vehicle(carModel));
        
        RentalServices rentalServices = new RentalServices(pricePerHours, pricePerDay, new BrazilTaxServices());
        
        rentalServices.processInvoice(cr);
        System.out.println();
        System.out.println("FATURA");
        System.out.println(String.format("Pagamento basico: %.2f ", cr.getInvoice().getBasicPayment()));
        System.out.println(String.format("Imposto: %.2f", cr.getInvoice().getTax()));
        System.out.println(String.format("Pagamento total: %.2f",  cr.getInvoice().totalPayment()));          
        
        input.close();
    }
}
