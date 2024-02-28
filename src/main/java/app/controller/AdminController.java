package app.controller;

import app.Validators.PersonInputsValidator;
import app.dto.PersonDto;

import java.util.Scanner;

public class AdminController {
    private static PersonInputsValidator personInputsValidator = new PersonInputsValidator();
    private static Scanner reader = new Scanner(System.in);

    public void createUser() throws Exception {
        System.out.print("Ingresa tu nombre completo");
        String fullName = reader.nextLine();
        personInputsValidator.fullNameValidator(fullName);
        System.out.println("Ingrese la cedula del usuario");
        long id = personInputsValidator.idValidator(reader.nextLine());
        System.out.print("Ingresa la edad del usuario");
        int age = personInputsValidator.ageValidator(reader.nextLine());
        personInputsValidator.ageValidator(age);
        PersonDto personDto = new PersonDto(id, fullName,age);
    }

}
