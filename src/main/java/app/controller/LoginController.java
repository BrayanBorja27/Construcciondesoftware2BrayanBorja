package app.controller;

import java.util.Scanner;

import app.Validators.PersonInputsValidator;
import app.dto.PersonDto;
import app.service.LoginService;
import app.service.VetShopService;
public class LoginController {
    private static Scanner reader = new Scanner(System.in);
    private static PersonInputsValidator personInputValidator = new PersonInputsValidator();
    private static LoginService loginService = new LoginService() {
        @Override
        public void setSesionID(long sesionId) {

        }

        @Override
        public void login(PersonDto personDto) throws Exception {

        }

        @Override
        public void logout() throws Exception {

        }
    };
    private static AdminController adminController = new AdminController();


    public void login() throws Exception {
        System.out.println("==============================");
        System.out.println("Ingrese su usuario");
        String userName = reader.nextLine();
        personInputValidator.userNameValidator(userName);
        System.out.println("Ingrese su contraseña");
        String password = reader.nextLine();
        personInputValidator.passwordValidator(password);
        PersonDto personDto = new PersonDto(userName, password);
        loginService.login(personDto);
        loginRouter(personDto);
        loginService.logout();
    }
    private void loginRouter(PersonDto personDto) {
        if (personDto.getRole().equals("Admin")) {
            adminController.sessionAdmin();
        } else if (personDto.getRole().equals("Vet")){
            adminController.sessionVet();
        }
    }

}
