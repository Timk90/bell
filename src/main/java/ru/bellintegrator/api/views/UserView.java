package ru.bellintegrator.api.views;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ru.bellintegrator.api.model.Country;
import ru.bellintegrator.api.model.Office;
import ru.bellintegrator.api.model.PersonalDoc;

@ApiModel(description = "Сотрудник")
public class UserView {

	@NotEmpty
	@ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
	private String id;

	@Size(max = 50)
	@NotEmpty(message = "name cannot be null")
	@ApiModelProperty(value = "Имя", example = "Иван")
	private String firstName;

	@Size(max = 50)
	@ApiModelProperty(value = "Фамилия", example = "Иванов")

	private String secondName;
	@Size(max = 50)
	@ApiModelProperty(value = "Отчество", example = "Иванович")
	private String middleName;

	@Size(max = 50)
	@NotEmpty(message = "position cannot be null")
	@ApiModelProperty(value = "должность", example = "менеджер")
	private String position;

	@Size(max = 50)
	@ApiModelProperty(value = "Телефон", example = "9323199813")
	private String phone;

	private String officeID;

	private String citizenship;
	
	private String personalDocumentName;
	
	private String personalDocumentNumber;
	
	private String personalDocumentDate;

	private boolean isIdentified;
	
	// getters ad setters
	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOfficeID() {
		return officeID;
	}

	public void setOfficeID(String officeID) {
		this.officeID = officeID;
	}

	public String getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

	public boolean isIdentified() {
		return isIdentified;
	}

	public void setIdentified(boolean isIdentified) {
		this.isIdentified = isIdentified;
	}

	public String getPersonalDocumentName() {
		return personalDocumentName;
	}

	public void setPersonalDocumentName(String personalDocumentName) {
		this.personalDocumentName = personalDocumentName;
	}

	public String getPersonalDocumentNumber() {
		return personalDocumentNumber;
	}

	public void setPersonalDocumentNumber(String personalDocumentNumber) {
		this.personalDocumentNumber = personalDocumentNumber;
	}

	public String getPersonalDocumentDate() {
		return personalDocumentDate;
	}

	public void setPersonalDocumentDate(String personalDocumentDate) {
		this.personalDocumentDate = personalDocumentDate;
	}

	public UserView() {

	}

	public UserView(@Size(max = 50) @NotEmpty(message = "name cannot be null") String id,
			@Size(max = 50) @NotEmpty(message = "name cannot be null") String firstName,
			@Size(max = 50) String secondName, 
			@Size(max = 50) String middleName,
			@Size(max = 50) @NotEmpty(message = "position cannot be null") String position,
			@Size(max = 50) String phone, 
			String personalDocumentName, 
			String personalDocumentNumber, 
			String personalDocumentDate, 
			String officeID, 
			String citizenship) {
		this.id = (id!=null) ? id: "no ID";
		this.firstName = (firstName!=null) ? firstName: "";
		this.secondName = (secondName!=null) ? secondName: "";
		this.middleName = (middleName!=null) ? middleName: "";
		this.position = (phone!=null) ? position: "";
		this.phone = (phone!=null) ? phone: "";
		this.personalDocumentName = (personalDocumentName!=null) ? personalDocumentName : "";
		this.personalDocumentNumber = (personalDocumentNumber!=null) ? personalDocumentNumber : "";
		this.personalDocumentDate = (personalDocumentDate!=null) ? personalDocumentDate : "";
		this.officeID = (officeID!=null) ? officeID: "";
		this.citizenship = (citizenship!=null) ?citizenship: "";
	}

	@Override
	public String toString() {
		return "{id:" + id + "officeId:" + officeID + ";firstname:" + firstName + ";secondName:" + secondName
				+ ";middleName:" + middleName + ";position:" + position + ";phone:" + phone + ";docName:"
				+ personalDocumentName + ";docNumber:" + personalDocumentNumber + ";docDate:"
				+ personalDocumentDate + ";citizenship:" + citizenship + ";isidentified:"
				+ isIdentified + "}";
	}

}
