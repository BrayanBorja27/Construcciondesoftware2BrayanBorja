package app.dao;

import app.config.MYSQLConnection;
import app.dto.ClinicHistoryDto;
import app.dto.OrderDto;
import app.dto.PetDto;
import app.models.ClinicHistory;
import app.service.VetShopService;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ClinicHistoryDaoImpl implements ClinicHistoryDao {
    public Connection connection = MYSQLConnection.getConnection();

    public ClinicHistoryDaoImpl() {

    }

    @Override
    public void createClinicHistory(ClinicHistoryDto clinicHistoryDto) throws Exception {
        String Sql = "INSERT INTO historia (veterinarian, reason_for_consultation, symptoms, diagnostic, procedures, medicines, id_order, vaccination_history, allergies, details_procedures) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
                    OrderDto order = new OrderDto();
                    order.setOrderId(idOrder);
                    clinicHistoryDto.setIdorder(order);
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


    public ClinicHistory searchClinicHistory(long petId) throws Exception {
        // Consulta la historia clínica de la mascota en la base de datos utilizando el ID de la mascota
        String sql = "SELECT id FROM historia WHERE mascota = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, petId);
        ResultSet resultSet = statement.executeQuery();

        // Crea una nueva instancia de ClinicHistory utilizando los datos de la historia clínica de la mascota
        if (resultSet.next()) {
            ClinicHistory clinicHistory = new ClinicHistory(
                    resultSet.getString("veterinarian"),
                    resultSet.getString("reason_for_consultation"),
                    resultSet.getString("symptoms"),
                    resultSet.getString("diagnostico"),
                    resultSet.getString("procedures"),
                    resultSet.getString("medicines"),
                    new OrderDto(resultSet.getLong("order_id")),
                    resultSet.getString("vaccination_history"),
                    resultSet.getString("allergies"),
                    resultSet.getString("details_procedures")
            );
            return clinicHistory;
        } else {
            return null;
        }
    }



    VetShopService service = new VetShopService(connection);

    @Override
    public void updateClinicHistory(ClinicHistoryDto clinicHistoryDto) throws Exception {
        String query = "UPDATE clinic_history SET ordercancelation = ? WHERE ORDEN = ?";
        PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, clinicHistoryDto.getEstado());
            statement.setLong(2, clinicHistoryDto.getIdorder().getOrderId());

    }

    @Override
    public void searchClinicHistory(OrderDto orderDto) throws Exception {
        // Consulta la historia clínica de la mascota en la base de datos utilizando el ID de la mascota
        String sql = "SELECT * FROM historia WHERE mascota = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setOrderDto(1, orderDto);
        ResultSet resultSet = statement.executeQuery();

        // Crea una nueva instancia de ClinicHistory utilizando los datos de la historia clínica de la mascota
        if (resultSet.next()) {
            ClinicHistory clinicHistory = new ClinicHistory(
                    resultSet.getString("veterinarian"),
                    resultSet.getString("reason_for_consultation"),
                    resultSet.getString("symptoms"),
                    resultSet.getString("diagnostico"),
                    resultSet.getString("procedures"),
                    resultSet.getString("medicines"),
                    new OrderDto(resultSet.getLong("order_id")),
                    resultSet.getString("vaccination_history"),
                    resultSet.getString("allergies"),
                    resultSet.getString("details_procedures")
            );
            }else {
            System.out.println("Id no valida");
        }


    }


}
