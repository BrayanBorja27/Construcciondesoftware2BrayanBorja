package app.dao;

import app.dto.ClinicHistoryDto;
import app.dto.OrderDto;

import java.util.List;

public interface ClinicHistoryDao {
    OrderDto orderDto = new OrderDto();
    void createClinicHistory(ClinicHistoryDto clinicHistoryDto) throws Exception;
    List<ClinicHistoryDto> getClinicHistories() throws Exception;

    void updateClinicHistory(ClinicHistoryDto clinicHistoryDto) throws Exception;
    void searchClinicHistory(ClinicHistoryDto orderDto) throws Exception;
}
