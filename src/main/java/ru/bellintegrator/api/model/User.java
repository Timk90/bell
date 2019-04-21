package ru.bellintegrator.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/*
 * Pattern for model
 * 
 */

//User model

@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private long id;

	/**
	 * Служебное поле hibernate
	 */
	@Version
	private Integer version;

	@Column(name = "first_name", length = 50, nullable = false)
	private String firstName;

	@Column(name = "second_name", length = 50)
	private String secondName;

	@Column(name = "middle_name", length = 50)
	private String middleName;

	@Column(name = "position", length = 50, nullable = false)
	private String position;

	private String phone;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "personal_doc_id")
	private PersonalDoc personalDocument;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "office_id")
	private Office office;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "citizenship_id")
	private Country citizenship;

	@Column(name = "is_identified")
	private boolean isIdentified;

	// getters and setters

	public long getId() {
		return id;
	}

	public PersonalDoc getPersonalDocument() {
		return personalDocument;
	}

	public void setPersonalDocument(PersonalDoc personalDocument) {
		this.personalDocument = personalDocument;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
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

	public PersonalDoc getPersonalDocumentDetails() {
		return personalDocument;
	}

	public void setPersonalDocumentDetails(PersonalDoc personalDocumentDetails) {
		this.personalDocument = personalDocumentDetails;
	}

	public Country getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(Country sitizenship) {
		this.citizenship = sitizenship;
	}

	public boolean isIdentified() {
		return isIdentified;
	}

	public void setIdentified(boolean isIdentified) {
		this.isIdentified = isIdentified;
	}

}
