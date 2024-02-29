package app.controller;

import java.util.Date;
import java.util.Scanner;
import app.Validators.BillInputsValidator;
import app.dto.BillDto;
import app.dto.PersonDto;
import app.models.Bill;

public class SellerController() {
    BillInputsValidator billInputsValidator = new BillInputsValidator();
    private static Scanner reader = new Scanner(System.in);

    public void createSell() throws Exception {
        System.out.println("Ingresa el nombre del producto");
        String productName = reader.nextLine();
        billInputsValidator.productNameValidator(productName);
        System.out.println("Ingresa el precio del producto");
        double price  = billInputsValidator.priceValidator(reader.nextLine());
        System.out.println("Ingresa la cantidad");
        int amount  = billInputsValidator.amountValidator(reader.nextLine());
        System.out.println("Ingresa la fecha");

        BillDto billDto = new Bill(invoiceId, idPet, idOwner, productName, price, amount, date);

    }
}
