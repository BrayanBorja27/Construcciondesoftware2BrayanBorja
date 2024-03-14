package app.dao;

import app.dto.ClinicHistoryDto;

import java.util.List;

public interface ClinicHistoryDao {
    void createClinicHistory(ClinicHistoryDto clinicHistoryDto) throws Exception;

    void updateClinicHistory(ClinicHistoryDto clinicHistoryDto) throws Exception;
    void searchClinicHistory(Long petId) throws Exception;
}
