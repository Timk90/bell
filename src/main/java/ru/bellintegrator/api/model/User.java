package ru.bellintegrator.api.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/*
 * Pattern for model
 * {
  “id”:””,
  “firstName”:””,
  “secondName”:””,
  “middleName”:””,
  “position”:””
  “phone”,””,
  “docName”:””,
  “docNumber”:””,
  “docDate”:””,
  “citizenshipName”:””,
  “citizenshipCode”:””,
  “isIdentified”:”true”
} 
 * 
 */

//User model

@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private long id; 
	
    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;
    
	
	@Column(name="first_name", length = 50, nullable=false)
	private String firstName;
	
	@Column(name="second_name", length = 50)
	private String secondName;
	
	@Column(name="middle_name", length = 50)
	private String middleName;
    
	@Column(name="middle_name", length = 50)
	private String position;
	
	private int phone;
	
	@Column(name="doc_name", length = 50)
	private String docName;
	
	@Column(name="doc_number")
	private int docNumber;
	
	@Column(name="doc_date")
	private Date docDate;
	
	@Column(name="citizenship_name", length = 50)
	private String sitizenshipName;	
	
	
	@Column(name="citizenship_code")
	private int sitizenshipCode;
	
	@Column(name="is_identified")
	private boolean isIdentified;
	
//getters and setters 

	public long getId() {
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

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public int getDocNumber() {
		return docNumber;
	}

	public void setDocNumber(int docNumber) {
		this.docNumber = docNumber;
	}

	public Date getDocDate() {
		return docDate;
	}

	public void setDocDate(Date docDate) {
		this.docDate = docDate;
	}

	public String getSitizenshipName() {
		return sitizenshipName;
	}

	public void setSitizenshipName(String sitizenshipName) {
		this.sitizenshipName = sitizenshipName;
	}

	public int getSitizenshipCode() {
		return sitizenshipCode;
	}

	public void setSitizenshipCode(int sitizenshipCode) {
		this.sitizenshipCode = sitizenshipCode;
	}

	public boolean isIdentified() {
		return isIdentified;
	}

	public void setIdentified(boolean isIdentified) {
		this.isIdentified = isIdentified;
	}
	
}
