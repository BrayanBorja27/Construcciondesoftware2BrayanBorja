package app.service;

import app.dto.ClinicHistoryDto;
import app.dto.PersonDto;
import app.dto.PetDto;

import java.util.Arrays;
import java.util.List;

public class VetShopService implements AdminService {
    private static final String [] rolls = {"Vendedor , Administrador , Veterinario"};

    @Override
    public void createUser(PersonDto personDto) throws Exception {
        List<String> rols = Arrays.asList(rolls);
        if(!rols.contains(personDto.getRole())){
            throw new Exception("El rol no es valido");
        }

    }

    @Override
    public void createPet(PetDto petDto) throws Exception {

    }

    @Override
    public void createClinicHistory(ClinicHistoryDto clinicHistoryDto) throws Exception {

    }
}
