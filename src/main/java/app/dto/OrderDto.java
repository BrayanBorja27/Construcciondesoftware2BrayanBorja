package app.dto;

import java.sql.Date;

public class OrderDto {
private long orderId;
private PetDto idPet;
private PersonDto idOwner;
private PersonDto person;
private String nameMedications;
private Date generationDate;

public OrderDto() {
	this.generationDate=new Date(System.currentTimeMillis());
}

public long getOrderId() {
	return orderId;
}
public void setOrderId(long orderId) {
	this.orderId = orderId;
}
public PetDto getIdPet() {
	return idPet;
}
public void setIdPet(PetDto idPet) {
	this.idPet = idPet;
}
public PersonDto getIdOwner() {
	return idOwner;
}
public void setIdOwner(PersonDto idOwner) {
	this.idOwner = idOwner;
}
public PersonDto getPerson() {
	return person;
}
public void setPerson(PersonDto person) {
	this.person = person;
}
public String getNameMedications() {
	return nameMedications;
}
public void setNameMedications(String nameMedications) {
	this.nameMedications = nameMedications;
}
public Date getGenerationDate() {
	return generationDate;
}
public void setGenerationDate(Date generationDate) {
	this.generationDate = generationDate;
}

}
