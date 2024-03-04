package app.dao;

import app.dto.PersonDto;

public interface LoginDao {
    public PersonDto login(PersonDto personDto) throws Exception;
    public PersonDto findSessionById(long sessionId) throws Exception;
    public void logout(long sessionId) throws Exception;
}
