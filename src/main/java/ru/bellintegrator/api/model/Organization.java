package ru.bellintegrator.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * организация
 */
@Entity
@Table(name = "Organization")
public class Organization {

	/**
	 * id организации (первичный ключ)
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;

	/**
	 * Служебное поле hibernate
	 */
	@Version
	private Integer version;

	/**
	 * имя организации
	 */
	@Column(name = "name", length = 50, nullable = false)
	private String name;

	/**
	 * полное имя организации
	 */
	@Column(name = "full_name", length = 50, nullable = false)
	private String fullName;

	/**
	 * ИНН организации
	 */
	@Column(name = "inn", nullable = false)
	private String inn;

	/**
	 * КПП организации
	 */
	@Column(name = "kpp", nullable = false)
	private String kpp;

	/**
	 * адрес организации
	 */
	@Column(name = "address", length = 50, nullable = false)
	private String address;

	/**
	 * телефон организации
	 */
	private String phone;

	/**
	 * активность организации
	 */
	@Column(name = "is_active")
	private boolean isActive;

	/**
	 * список офисов данной организации внешний ключ на таблицу офисов
	 */
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "organization_id")
	private List<Office> offices;

	/**
	 * синхронизации офиса и организации
	 * 
	 * @param office
	 */
	public void addOffice(Office office) {
		getOffices().add(office);
		office.setOrganization(this);
	}

	/**
	 * удаление офиса из списка
	 * 
	 * @param office
	 */
	public void removeOffice(Office office) {
		getOffices().remove(office);
		office.setOrganization(null);
	}

	public List<Office> getOffices() {
		return offices;
	}

	public void setOffices(List<Office> offices) {
		this.offices = offices;
	}

	public Organization() {
	}

	public Organization(Long id) {
		this.id = id;
	}

	public Long getId() {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getInn() {
		return inn;
	}

	public void setInn(String inn) {
		this.inn = inn;
	}

	public String getKpp() {
		return kpp;
	}

	public void setKpp(String kpp) {
		this.kpp = kpp;
	}

}
