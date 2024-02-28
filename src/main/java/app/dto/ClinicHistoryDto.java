package app.dto;

import java.sql.Date;

public class ClinicHistoryDto {
private Date registerDate;
private String veterinarian;
private String reasonForConsultation;
private String symptoms;
private String procedures;
private String medicines;
private OrderDto idOrder;
private String vaccinationHistory;w
private String allergies;
private String detailsProcedures;

public ClinicHistoryDto() {
	this.registerDate=new Date(System.currentTimeMillis());
}

public Date getRegisterDate() {
	return registerDate;
}
public void setRegisterDate(Date registerDate) {
	this.registerDate = registerDate;
}
public String getVeterinarian() {
	return veterinarian;
}
public void setVeterinarian(String veterinarian) {
	this.veterinarian = veterinarian;
}
public String getReasonForConsultation() {
	return reasonForConsultation;
}
public void setReasonForConsultation(String reasonForConsultation) {
	this.reasonForConsultation = reasonForConsultation;
}
public String getSymptoms() {
	return symptoms;
}
public void setSymptoms(String symptoms) {
	this.symptoms = symptoms;
}
public String getProcedures() {
	return procedures;
}
public void setProcedures(String procedures) {
	this.procedures = procedures;
}
public String getMedicines() {
	return medicines;
}
public void setMedicines(String medicines) {
	this.medicines = medicines;
}
public OrderDto getIdorder() {
	return idOrder;
}
public void setIdorder(OrderDto idorder) {
	this.idOrder = idorder;
}
public String getVaccinationHistory() {
	return vaccinationHistory;
}
public void setVaccinationHistory(String vaccinationHistory) {
	this.vaccinationHistory = vaccinationHistory;
}
public String getAllergies() {
	return allergies;
}
public void setAllergies(String allergies) {
	this.allergies = allergies;
}
public String getDetailsProcedures() {
	return detailsProcedures;
}
public void setDetailsProcedures(String detailsProcedures) {
	this.detailsProcedures = detailsProcedures;
}


}
