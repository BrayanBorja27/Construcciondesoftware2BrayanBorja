package app.service;

import app.dto.ClinicHistoryDto;
import app.dto.PersonDto;
import app.dto.PetDto;

public interface AdminService {
    public void createUser(PersonDto personDto) throws Exception;
    public void createPet(PetDto petDto) throws Exception;
    public void createClinicHistory(ClinicHistoryDto clinicHistoryDto) throws Exception;
}
