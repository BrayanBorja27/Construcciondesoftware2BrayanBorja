package app.dao;

import app.config.MYSQLConnection;
import app.dto.ClinicHistoryDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ClinicHistoryDaoImpl implements ClinicHistoryDao {
    public Connection connection = MYSQLConnection.getConnection();

    public ClinicHistoryDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createClinicHistory(ClinicHistoryDto clinicHistoryDto) throws Exception {
        String Sql = "INSERT INTO clinic_history (veterinarian, reason_for_consultation, symptoms, diagnostic, procedures, medicines, id_order, vaccination_history, allergies, details_procedures) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String selectSql = "SELECT LAST_INSERT_ID()";
        try (
             PreparedStatement insertStatement = connection.prepareStatement(Sql);
             PreparedStatement selectStatement = connection.prepareStatement(selectSql)) {

            insertStatement.setString(1, clinicHistoryDto.getVeterinarian());
            insertStatement.setString(2, clinicHistoryDto.getReasonForConsultation());
            insertStatement.setString(3, clinicHistoryDto.getSymptoms());
            insertStatement.setString(4, clinicHistoryDto.getDiagnostico());
            insertStatement.setString(5, clinicHistoryDto.getProcedures());
            insertStatement.setString(6, clinicHistoryDto.getMedicines());
            insertStatement.setString(7, clinicHistoryDto.getVaccinationHistory());
            insertStatement.setString(8, clinicHistoryDto.getAllergies());
            insertStatement.setString(9, clinicHistoryDto.getDetailsProcedures());

            insertStatement.executeUpdate();

            try (ResultSet resultSet = selectStatement.executeQuery()) {
                if (resultSet.next()) {
                    int idOrder = resultSet.getInt(1);
                    clinicHistoryDto.setIdorder();
                } else {
                    throw new Exception("No se pudo obtener el valor generado automáticamente para idOrder.");
                }
            }

        } catch (SQLException e) {
            throw new Exception("Ocurrió un error al crear la historia clínica.", e);
        }
    }


    @Override
    public List<ClinicHistoryDto> getClinicHistories() throws Exception {
        return null;
    }

    @Override
    public void updateClinicHistory(ClinicHistoryDto clinicHistoryDto) throws Exception {

    }

    @Override
    public void deleteClinicHistory(int id) throws Exception {

    }

    // Implementa los demás métodos de la interfaz ClinicHistoryDao
}
