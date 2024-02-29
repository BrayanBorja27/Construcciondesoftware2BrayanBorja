package app.controller;

import app.Validators.ClinicHistoryInputsValidator;
import app.Validators.PetInputsValidator;
import app.dto.ClinicHistoryDto;
import app.dto.PetDto;

import java.util.Scanner;

public class VetController {
    private static ClinicHistoryInputsValidator clinicHistoryInputsValidator = new ClinicHistoryInputsValidator();
    private static PetInputsValidator petInputsValidator = new PetInputsValidator();
    private static Scanner reader = new Scanner(System.in);


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

        PetDto petDto = new PetDto(name,age, idNumber, species, breed, characteristics, weight, idOwner)
    }
}
