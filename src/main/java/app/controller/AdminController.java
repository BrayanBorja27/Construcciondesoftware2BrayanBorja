package app.controller;

import app.Validators.*;
import app.dto.BillDto;
import app.dto.ClinicHistoryDto;
import app.dto.PersonDto;
import app.dto.PetDto;
import app.models.Bill;
import app.service.AdminService;
import app.service.VetShopService;

import java.util.Scanner;

public class AdminController {
    private static PersonInputsValidator personInputsValidator = new PersonInputsValidator();
    private static ClinicHistoryInputsValidator clinicHistoryInputsValidator = new ClinicHistoryInputsValidator();
    BillInputsValidator billInputsValidator = new BillInputsValidator();
    OrderInputsValidator orderInputsValidator = new OrderInputsValidator();

    PetInputsValidator petInputsValidator = new PetInputsValidator();

    private static AdminService adminService = new AdminService() {
        @Override
        public void createUser(PersonDto personDto) throws Exception {

        }

        @Override
        public void createPet(PetDto petDto) throws Exception {

        }

        @Override
        public void createClinicHistory(ClinicHistoryDto clinicHistoryDto) throws Exception {

        }

        @Override
        public void createOwnerUser(PersonDto personDto) throws Exception {

        }
    }



    private static Scanner reader = new Scanner(System.in);

    private static final String MENUADMIN = "1. Crear usuario \n2. Cerrar sesion";
    private static final String MENUVET = "1. Crear dueño \n2. Crear Historia Clinica \n3. Para crear Mascota \n4. Consultar Historia Clinica \n5. Editar Historia Clinica \n6. Listado Ordenes \n7. Anular Orden \n8. Cerrar sesion";
    private static final String MENUSELLER = "1. Para crear Factura \n2. Para cerrar sesion";
    //SESION ADMIN
    public void sessionAdmin() {
        boolean runApp = true;
        while (runApp) {
            try {
                System.out.println("==========INGRESE=============");
                System.out.println(MENUADMIN);
                System.out.println("==============================");
                String option = reader.nextLine();
                runApp = menuAdmin(option);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    private boolean menuAdmin(String option) throws Exception {
        switch (option) {
            case "1": {
                createUser();
                return true;
            }
            case "2": {
                return false;
            }
            default: {
                System.out.println("ingrese una opcion valida");
                return true;
            }
        }
    }

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

    public void sessionVet() {
        boolean runApp = true;
        while (runApp) {
            try {
                System.out.println("==========INGRESE=============");
                System.out.println(MENUVET);
                System.out.println("==============================");
                String option = reader.nextLine();
                runApp = menuVet(option);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    private boolean menuVet(String option) throws Exception {
        switch (option) {
            case "1": {
                createOwnerUser();
                return true;
            }
            case "2":{
                createClinicHistory();
                return true;
            }
            case "3":{
                createPet();
                return true;
            }
            case "8": {
                return false;
            }
            default: {
                System.out.println("ingrese una opcion valida");
                return true;
            }
        }
    }

    public void createOwnerUser() throws Exception {
        System.out.println("==============================");
        System.out.println("Ingresa la cedula");
        Long id = personInputsValidator.idValidator(reader.nextLine());
        System.out.println("Ingresa el nombre completo");
        String fullName = reader.nextLine();
        personInputsValidator.fullNameValidator(fullName);
        System.out.println("Ingresa la edad");
        int age = personInputsValidator.ageValidator(reader.nextLine());
        String role = "Owner";
        String userName = "N/A";
        String password = "N/A";
        PersonDto personDto = new PersonDto(id, fullName, age, role, userName, password);
        adminService.createOwnerUser(personDto);
    }

    public void createClinicHistory() throws Exception {
        System.out.println("Ingresa tu nombre completo de Veterinario");
        String veterinarian = reader.nextLine();
        clinicHistoryInputsValidator.veterinarianValidator(veterinarian);
        System.out.println("Ingresa la razon de consulta");
        String reasonForConsultation = reader.nextLine();
        clinicHistoryInputsValidator.reasonForConsultationValidator(reasonForConsultation);
        System.out.println("Ingresa los sintomas");
        String symptoms = reader.nextLine();
        clinicHistoryInputsValidator.symptomsValidator(symptoms);
        System.out.println("Ingresa el diagnostico");
        String diagnostic = reader.nextLine();
        clinicHistoryInputsValidator.diagnosticValidator(diagnostic);
        System.out.println("Ingresa el procedimiento");
        String procedures = reader.nextLine();
        clinicHistoryInputsValidator.proceduresValidator(procedures);
        System.out.println("Ingresa las medicinas recomendadas");
        String medicines = reader.nextLine();
        clinicHistoryInputsValidator.medicinesValidator(medicines);
        System.out.println("Ingresa el historial de vacunacion");
        String vaccinationHistory = reader.nextLine();
        clinicHistoryInputsValidator.vaccionationHistoryValidator(vaccinationHistory);
        System.out.println("Ingresa las alergias");
        String allergies = reader.nextLine();
        clinicHistoryInputsValidator.allergiesValidator(allergies);
        System.out.println("Ingresa los detaller dle procedimiento");
        String detailsProcedures = reader.nextLine();
        clinicHistoryInputsValidator.medicinesValidator(detailsProcedures);




        ClinicHistoryDto clinicHistoryDto = new ClinicHistoryDto( veterinarian,  reasonForConsultation, symptoms, diagnostic, procedures, medicines, idOrder, vaccinationHistory,allergies, detailsProcedures);


    }

    private void createPet()throws Exception{
        System.out.println("Ingresa el nombre de la mascota");
        String name = reader.nextLine();
        petInputsValidator.nameValidator(name);
        System.out.println("Ingresa la cedula del dueño");
        long idOwner  = petInputsValidator.ownerValidator(reader.nextLine());
        System.out.println("Ingresa la edad de la mascota");
        int age = petInputsValidator.ageValidator(reader.nextLine());
        System.out.println("Ingresa la especie");
        String species = reader.nextLine();
        petInputsValidator.speciesValidator(species);
        System.out.println("Ingresa la raza de la mascota");
        String breed = reader.nextLine();
        petInputsValidator.breedValidator(breed);
        System.out.println("Ingresa las caracteristicas");
        String characteristics = reader.nextLine();
        petInputsValidator.characteristicsValidator(characteristics);
        System.out.println("Ingresa el peso de la mascota");
        double weight  = petInputsValidator.weightValidator(reader.nextLine());

        PetDto petDto = new PetDto(name,age, idNumber, species, breed, characteristics, weight, idOwner);
    }

    public void sessionSeller() {
        boolean runApp = true;
        while (runApp) {
            try {
                System.out.println("==========INGRESE=============");
                System.out.println(MENUSELLER);
                System.out.println("==============================");
                String option = reader.nextLine();
                runApp = menuVet(option);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }
    private boolean menuSeller(String option) throws Exception {
        switch (option) {
            case "1": {
                createBill();
                return true;
            }
            case "2": {
                return false;
            }
            default: {
                System.out.println("ingrese una opcion valida");
                return true;
            }
        }
    }

    public void createBill() throws Exception {
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
