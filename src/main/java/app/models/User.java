package app.models;

public class User {
private String user;
private String password;
private String role;
private Person person;

public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public Person getPerson() {
	return person;
}
public void setPerson(Person person) {
	this.person = person;
}

}
