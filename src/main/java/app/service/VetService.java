package app.service;
import  app.dto.ClinicHistoryDto;
public interface VetService {
    public void createClinicHistory (ClinicHistoryDto clinicHistoryDto) throws Exception;
    public  void SearchClinicHistory (Long petId) throws Exception;
}
