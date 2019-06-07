package ru.bellintegrator.api.views;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Организация")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrganizationView {

	@NotEmpty
	@ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
	private String id;

	@Size(max = 50)
	@NotEmpty(message = "name cannot be null")
	@ApiModelProperty(value = "Название", example = "Bosh")
	private String name;

	@Size(max = 50)
	@ApiModelProperty(value = "Полное название", example = "Bosh Lim. Inc.")
	private String fullName;

	@Size(max = 50)
	@ApiModelProperty(value = "ИНН", example = "321311313")
	private String inn;

	@Size(max = 50)
	@ApiModelProperty(value = "КПП", example = "3123131232")
	private String kpp;

	@Size(max = 50)
	@ApiModelProperty(value = "Адрес", example = "Восход 13")
	private String address;

	@Size(max = 50)
	@ApiModelProperty(value = "Телефон", example = "9323199813")
	private String phone;

	private boolean isActive;

	public OrganizationView() {

	}

	public OrganizationView(@NotEmpty String id, @Size(max = 50) @NotEmpty(message = "name cannot be null") String name,
			@Size(max = 50) String fullName, @Size(max = 50) String inn, @Size(max = 50) String kpp,
			@Size(max = 50) String phone, boolean isActive) {
		this.id = id;
		this.name = name;
		this.fullName = fullName;
		this.inn = inn;
		this.kpp = kpp;
		this.phone = phone;
		this.isActive = isActive;
	}

	// getters and setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "{id:" + id + "; name:" + name + "; fullName:" + fullName + "; inn:" + inn + "; kpp:" + kpp
				+ "; address:" + address + "; phone:" + phone + "; isActive:" + isActive + "}";
	}

}
