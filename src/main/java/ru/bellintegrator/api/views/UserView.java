package ru.bellintegrator.api.views;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * представление сотрудника
 */
@ApiModel(description = "Сотрудник")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserView {

	/**
	 * ID представления сотрудника
	 */
	@NotEmpty
	@ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
	private String id;

	/**
	 * имя представления сотрудника
	 */
	@Size(max = 50)
	@NotEmpty(message = "name cannot be null")
	@ApiModelProperty(value = "Имя", example = "Иван")
	private String firstName;

	/**
	 * фамилия представления сотрудника
	 */
	@Size(max = 50)
	@ApiModelProperty(value = "Фамилия", example = "Иванов")
	private String secondName;

	/**
	 * отчество представления сотрудника
	 */
	@Size(max = 50)
	@ApiModelProperty(value = "Отчество", example = "Иванович")
	private String middleName;

	/**
	 * должность представления сотрудника
	 */
	@Size(max = 50)
	@NotEmpty(message = "position cannot be null")
	@ApiModelProperty(value = "должность", example = "менеджер")
	private String position;

	/**
	 * номер телефона представления сотрудника
	 */
	@Size(max = 50)
	@ApiModelProperty(value = "Телефон", example = "9323199813")
	private String phone;

	/**
	 * ID офиса представления сотрудника
	 */
	private String officeId;

	/**
	 * код страны представления сотрудника
	 */
	private String citizenshipCode;

	/**
	 * имя личного документа представления сотрудника
	 */
	private String docName;

	/**
	 * номер личного документа представления сотрудника
	 */
	private String docNumber;

	/**
	 * дата выдачи личного документа представления сотрудника
	 */
	private String docDate;

	/**
	 * активность представления сотрудника
	 */
	private boolean isIdentified;

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

	public String getOfficeId() {
		return officeId;
	}

	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}

	public String getCitizenshipCode() {
		return citizenshipCode;
	}

	public void setCitizenshipCode(String citizenshipCode) {
		this.citizenshipCode = citizenshipCode;
	}

	public boolean isIdentified() {
		return isIdentified;
	}

	public void setIdentified(boolean isIdentified) {
		this.isIdentified = isIdentified;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDocNumber() {
		return docNumber;
	}

	public void setDocNumber(String docNumber) {
		this.docNumber = docNumber;
	}

	public String getDocDate() {
		return docDate;
	}

	public void setDocDate(String docDate) {
		this.docDate = docDate;
	}

	public UserView() {

	}

	public UserView(@Size(max = 50) @NotEmpty(message = "name cannot be null") String id,
			@Size(max = 50) @NotEmpty(message = "name cannot be null") String firstName,
			@Size(max = 50) String secondName, @Size(max = 50) String middleName,
			@Size(max = 50) @NotEmpty(message = "position cannot be null") String position,
			@Size(max = 50) String phone, String personalDocumentName, String personalDocumentNumber,
			String personalDocumentDate, String officeId, String citizenship) {
		this.id = (id != null) ? id : "no ID";
		this.firstName = (firstName != null) ? firstName : "";
		this.secondName = (secondName != null) ? secondName : "";
		this.middleName = (middleName != null) ? middleName : "";
		this.position = (phone != null) ? position : "";
		this.phone = (phone != null) ? phone : "";
		this.docName = (personalDocumentName != null) ? personalDocumentName : "";
		this.docNumber = (personalDocumentNumber != null) ? personalDocumentNumber : "";
		this.docDate = (personalDocumentDate != null) ? personalDocumentDate : "";
		this.officeId = (officeId != null) ? officeId : "";
		this.citizenshipCode = (citizenship != null) ? citizenship : "";
	}

	@Override
	public String toString() {
		return "{id:" + id + ";officeId:" + officeId + ";firstname:" + firstName + ";secondName:" + secondName
				+ ";middleName:" + middleName + ";position:" + position + ";phone:" + phone + ";docName:" + docName
				+ ";docNumber:" + docNumber + ";docDate:" + docDate + ";citizenship:" + citizenshipCode
				+ ";isidentified:" + isIdentified + "}";
	}

}
