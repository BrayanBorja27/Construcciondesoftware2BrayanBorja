package app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import app.config.MYSQLConnection;
import app.dto.PersonDto;
import app.dto.SessionDto;

public class LoginDaoImpl implements LoginDao {
    public Connection connection = MYSQLConnection.getConnection();

    @Override
    public SessionDto login(PersonDto personDto) throws Exception {
        String query = "INSERT INTO SESION(username,role) VALUES (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        int i = 1;
        preparedStatement.setString(i++, personDto.getUserName());
        preparedStatement.setString(i++, personDto.getRole());
        preparedStatement.execute();
        query = "SELECT ID,ROLE,USERNAME FROM SESION WHERE USERNAME = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, personDto.getUserName());
        ResultSet resulSet = preparedStatement.executeQuery();
        if (resulSet.next()) {
            long id = resulSet.getLong("ID");
            String userName = resulSet.getString("USERNAME");
            String userRol = resulSet.getString("ROLE");
            resulSet.close();
            preparedStatement.close();
            return new SessionDto(id, userName, userRol);
        }
        resulSet.close();
        preparedStatement.close();
        return null;
    }

    @Override
    public void logout(long sessionId) throws Exception {
        String query = "DELETE FROM SESION WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, sessionId);
        preparedStatement.execute();
        preparedStatement.close();

    }

    @Override
    public SessionDto findSessionById(long sessionId) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }


}
