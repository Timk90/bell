package ru.bellintegrator.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/*
 * {
  “id”:””, //обязательный параметр
  “name”:””, //обязательный параметр
  “address”:””, //обязательный параметр
  “phone”,””,
  “isActive”:”true” //пример
}* 
 */

//Office model

@Entity
@Table(name = "Office")
public class Office {
	
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
