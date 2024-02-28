package app.Validators;

public class PetInputsValidator extends InputsValidator{
	
	public void nameValidator(String name) throws Exception {
        super.stringValidator(name, " Nombre de mascota incorrecto");
    }
	public int ageValidator(String age) throws Exception{
		   return super.integerValidator(age, "Ingrese edad de la mascota");
	}
	public long idNumberValidator(String idNumber) throws Exception {
        return super.longValidator(idNumber, " identificacion de mascota");
    }
	public void speciesValidator(String species) throws Exception {
        super.stringValidator(species, " Nombre de mascota incorrecto");
    }
	public void raceValidator(String race) throws Exception {
        super.stringValidator(race, " Nombre de mascota incorrecto");
    }
	public void characteristicsValidator(String characteristics) throws Exception {
        super.stringValidator(characteristics, " Nombre de mascota incorrecto");
    }
	public double weightValidator(String weight) throws Exception {
        return super.doubleValidator(weight, " id de mascota");
    }
	public long ownerValidator(String owner) throws Exception {
        return super.longValidator(owner, " identificación de mascota");
    }
}
