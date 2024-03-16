package app.service;

import app.dao.*;
import app.dto.*;

import java.sql.Connection;
import java.util.Arrays;
import java.util.List;

public class VetShopService implements AdminService , LoginService , VetService {

    private static final String[] rolls = {"Administrador", "Vendedor", "Veterinario"};
    private static long sessionId = 0L;
    private Connection connection;

    public VetShopService(Connection connection) {
        this.connection = connection;
    }





    @Override
    public void createUser(PersonDto personDto) throws Exception {
        List<String> validRols = Arrays.asList(rolls);
        if(!validRols.contains(personDto.getRole())){
            throw new Exception("El rol no es válido");
        }
        PersonDao personDao = new PersonDaoImpl();
        if (personDao.findUserExist(personDto)) {
            throw new Exception("Ya existe un usuario con esa cedula");
        }
        if (personDao.existUserByUserName(personDto)) {
            throw new Exception("Ya existe el usuario");
        }
        personDao.createPerson(personDto);
        System.out.println("Se ha creado el usuario");
    }

    public VetShopService() {
    }

    @Override
    public void setSesionID(long sesionId) {
        sessionId = sesionId;
    }

    @Override
    public void login(PersonDto personDto) throws Exception {
        PersonDao personDao = new PersonDaoImpl();
        PersonDto personDtoValidate = personDao.findUserByUserName(personDto);
        if (personDtoValidate == null) {
            throw new Exception("Usuario no valido");
        }
        if (!personDto.getPassword().equals(personDtoValidate.getPassword())) {
            throw new Exception("Usuario o contraseña incorrecta");
        }
        personDto.setRole(personDtoValidate.getRole());
        LoginDao loginDao = new LoginDaoImpl();
        SessionDto sessionDto = loginDao.login(personDtoValidate);
        setSesionID(sessionDto.getId());
    }

    @Override
    public void logout() throws Exception {
        LoginDao loginDao = new LoginDaoImpl();
        loginDao.logout(sessionId);
        setSesionID(0);
    }


    private ClinicHistoryDao clinicHistoryDao;



    // ...

    @Override
    public void createClinicHistory(ClinicHistoryDto clinicHistoryDto) throws Exception {
        ClinicHistoryDto clinicHistory = new ClinicHistoryDto(clinicHistoryDto.getVeterinarian(), clinicHistoryDto.getReasonForConsultation(), clinicHistoryDto.getSymptoms(), clinicHistoryDto.getDiagnostico(), clinicHistoryDto.getProcedures(), clinicHistoryDto.getMedicines(), clinicHistoryDto.getIdorder() , clinicHistoryDto.getVaccinationHistory(), clinicHistoryDto.getAllergies(), clinicHistoryDto.getDetailsProcedures());
        this.clinicHistoryDao.createClinicHistory(clinicHistoryDto);
    }

    @Override
    public void SearchClinicHistory(ClinicHistoryDto orderDto) throws Exception {
        // Consulta la historia clínica de la mascota en la base de datos utilizando el ID de la mascota
        ClinicHistoryDao clinicHistory = new ClinicHistoryDaoImpl();
        clinicHistory.searchClinicHistory(orderDto.getIdorder());

        //Crea una nueva instancia de ClinicHistoryDto utilizando los datos de la historia clínica de la mascota
        ClinicHistoryDto clinicHistoryDto = new ClinicHistoryDto(clinicHistory.getVeterinarian(), clinicHistory.getReasonForConsultation(), clinicHistory.getSymptoms(), clinicHistory.getDiagnostico(), clinicHistory.getProcedures(), clinicHistory.getMedicines(), clinicHistory.getIdOrder(), clinicHistory.getVaccinationHistory(), clinicHistory.getAllergies(), clinicHistory.getDetailsProcedures());

        return clinicHistoryDto;
    }


    @Override
    public void createOwnerUser(PersonDto personDto) throws Exception {

    }


}


