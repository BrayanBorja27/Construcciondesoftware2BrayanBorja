package app.service;

import app.dto.ClinicHistoryDto;
import app.dto.PersonDto;
import app.dto.PetDto;

public interface AdminService {
    public void createUser(PersonDto personDto) throws Exception;


    public void createOwnerUser(PersonDto personDto) throws Exception;
}
