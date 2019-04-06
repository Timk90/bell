package ru.bellintegrator.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/*
 * 
 * 2. api/organization/{id}
 * method:GET
	Out:
	{
	  “id”:””,
	  “name”:””,
	  “fullName”:””,
	  “inn”:””,
	  “kpp”:””,
	  “address”:””,
	  “phone”,””,
	  “isActive”:”true”
}
*/

//Organization model

@Entity
@Table(name = "Organization")
public class Organization {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private long id; 
	
    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;
    
	@Column(name="name", length = 50, nullable=false)
	private String name;
	
	@Column(name="full_name", length = 50, nullable=false)
	private String fullName;
	
	@Column(name="inn", nullable=false)
	private int inn;
	
	@Column(name="kpp", nullable=false)
	private int kpp;
	
	@Column(name="address", length = 50, nullable=false)
	private String address;
	
	private int phone;
	
	@Column(name="is_active")
	private boolean isActive;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getInn() {
		return inn;
	}

	public void setInn(int inn) {
		this.inn = inn;
	}

	public int getKpp() {
		return kpp;
	}

	public void setKpp(int kpp) {
		this.kpp = kpp;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}
