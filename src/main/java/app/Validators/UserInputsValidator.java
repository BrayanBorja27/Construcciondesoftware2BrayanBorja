package app.Validators;

public class UserInputsValidator extends InputsValidator{
	
	public void userValidator(String user) throws Exception {
        super.stringValidator(user, " Nombre de mascota incorrecto");
    }
	public void passwordValidator(String password) throws Exception {
        super.stringValidator(password, " Nombre de mascota incorrecto");
    }
	public void roleValidator(String role) throws Exception {
        super.stringValidator(role, " Nombre de mascota incorrecto");
    }
	public long personValidator(String person) throws Exception {
        return super.longValidator(person, " identificacion de mascota");
    }

}
