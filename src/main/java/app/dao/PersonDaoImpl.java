package app.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import app.config.MYSQLConnection;
import app.dto.PersonDto;
import app.models.Person;
import app.controller.AdminController;

public class PersonDaoImpl implements PersonDao {
    public Connection connection = MYSQLConnection.getConnection();

    @Override
    public void createPerson(PersonDto personDto) throws Exception {
        String query = "INSERT INTO persona(cedula,nombre,edad,username,password, Rol) VALUES (?,?,?,?,?,?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setLong(1, personDto.getId());
            preparedStatement.setString(2 , personDto.getFullName());
            preparedStatement.setInt(3, personDto.getAge());
            preparedStatement.setString(4, personDto.getUserName());
            preparedStatement.setString(5, personDto.getPassword());
            preparedStatement.setString(6, personDto.getRole());
            preparedStatement.execute();
            preparedStatement.close();
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 1) {
                System.out.println("Usuario creado correctamente en la base de datos.");
            } else {
                System.out.println("Error al crear el usuario en la base de datos.");
            }
        }
    }

    @Override
    public boolean findUserExist(PersonDto personDto) throws Exception {
        String query = "SELECT 1 FROM PERSONA WHERE cedula = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, personDto.getId());
        ResultSet resulSet = preparedStatement.executeQuery();
        boolean userExists = resulSet.next();
        resulSet.close();
        preparedStatement.close();
        return userExists;
    }

    @Override
    public PersonDto findUserById(PersonDto personDto) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean existUserByUserName(PersonDto personDto) throws Exception {
        String query = "SELECT 1 FROM PERSONA WHERE username = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, personDto.getUserName());
        ResultSet resulSet = preparedStatement.executeQuery();
        boolean userExists = resulSet.next();
        resulSet.close();
        preparedStatement.close();
        return userExists;
    }

    @Override
    public PersonDto findUserByUserName(PersonDto personDto) throws Exception {
        String query = "SELECT cedula,nombre,edad, Rol,username,password FROM PERSONA WHERE username = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, personDto.getUserName());
        ResultSet resulSet = preparedStatement.executeQuery();
        if(resulSet.next()) {
            Person person = new Person();
            person.setId(resulSet.getLong("CEDULA"));
            person.setFullName(resulSet.getString("NOMBRE"));
            person.setAge(resulSet.getInt("EDAD"));
            person.setRole(resulSet.getString("ROL"));
            person.setUserName(resulSet.getString("USERNAME"));
            person.setPassword(resulSet.getString("PASSWORD"));
            resulSet.close();
            preparedStatement.close();
            return new PersonDto(person);
        }
        resulSet.close();
        preparedStatement.close();
        return null;
    }

}
