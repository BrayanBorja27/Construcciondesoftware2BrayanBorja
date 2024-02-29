package app.controller;

import app.Validators.*;
import app.dto.PersonDto;
import app.service.AdminService;
import app.service.VetShopService;

import java.util.Scanner;

public class AdminController {
    private static PersonInputsValidator personInputsValidator = new PersonInputsValidator();
    private static AdminService adminService = new VetShopService();


    private static Scanner reader = new Scanner(System.in);

    public void createUser() throws Exception {
        System.out.println("Ingresa tu nombre completo");
        String fullName = reader.nextLine();
        personInputsValidator.fullNameValidator(fullName);
        System.out.println("Ingrese la cedula del usuario");
        long id = personInputsValidator.idValidator(reader.nextLine());
        System.out.println("Ingresa la edad del usuario");
        int age = personInputsValidator.ageValidator(reader.nextLine());
        System.out.println("Ingrese el rol de usuario");
        String rol = reader.nextLine();
        personInputsValidator.rollValidator(rol);
        System.out.println("Ingrese el nombre de usuario");
        String userName = reader.nextLine();
        personInputsValidator.userNameValidator(userName);
        System.out.println("ingrese la contraseña");
        String password = reader.nextLine();
        personInputsValidator.passwordValidator(password);
        PersonDto personDto = new PersonDto(id , fullName , age ,rol , userName , password);
        System.out.println("Se cumplieron todas las validaciones");
        adminService.createUser(personDto);

    }

}
