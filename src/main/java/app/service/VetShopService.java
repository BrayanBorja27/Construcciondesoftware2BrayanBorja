package app.service;

import app.dao.*;
import app.dto.ClinicHistoryDto;
import app.dto.PersonDto;
import app.dto.PetDto;
import app.dto.SessionDto;
import app.models.ClinicHistory;

import java.sql.Connection;
import java.util.Arrays;
import java.util.List;

public class VetShopService implements AdminService , LoginService {

    private static final String [] rolls = {"Vendedor , Administrador , Veterinario"};
    private static long sessionId = 0L;




    @Override
    public void createUser(PersonDto personDto) throws Exception {
        List<String> rols = Arrays.asList(rolls);
        if(!rols.contains(personDto.getRole())){
            throw new Exception("El rol no es valido");
        }
        PersonDao personDao = new PersonDaoImpl();
        if (personDao.findUserExist(personDto)) {
            throw new Exception("ya existe un usuario con esa cedula");
        }
        if (personDao.existUserByUserName(personDto)) {
            throw new Exception("ya existe el usuario");
        }
        personDao.createPerson(personDto);
        System.out.println("se ha creado el usuario");

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

    @Override
    public void createPet(PetDto petDto) throws Exception {

    }

    private ClinicHistoryDao clinicHistoryDao;

    public VetShopService(Connection connection) {
        this.clinicHistoryDao = new ClinicHistoryDaoImpl(connection);
    }

    // ...

    @Override
    public void createClinicHistory(ClinicHistoryDto clinicHistoryDto) throws Exception {
        ClinicHistory clinicHistory = new ClinicHistory(clinicHistoryDto.getVeterinarian(), clinicHistoryDto.getReasonForConsultation(), clinicHistoryDto.getSymptoms(), clinicHistoryDto.getDiagnostic(), clinicHistoryDto.getProcedures(), clinicHistoryDto.getMedicines(), clinicHistoryDto.getIdOrder(), clinicHistoryDto.getVaccinationHistory(), clinicHistoryDto.getAllergies(), clinicHistoryDto.getDetailsProcedures());
        clinicHistoryDao.createClinicHistory(clinicHistoryDto);
}
}


