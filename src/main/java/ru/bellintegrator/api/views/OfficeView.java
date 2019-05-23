package ru.bellintegrator.api.views;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "офис")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OfficeView {

	@NotEmpty
	@ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
	private String id;

	@Size(max = 50)
	//@NotEmpty(message = "name cannot be null")
	@ApiModelProperty(value = "Название", example = "Bosh Inc Ltd itd...")
	private String name;
	
	@Size(max = 50)
	@ApiModelProperty(value = "Адрес", example = "Восход 13")
	private String address;

	@Size(max = 50)
	@ApiModelProperty(value = "Телефон", example = "9323199813")
	private String phone;
	
	@Size(max = 50)
	@ApiModelProperty(value = "ID организации", example = "1")
	private String orgId;
	
	private boolean isActive;

	public OfficeView() {
	}

	public OfficeView(@NotEmpty String id, @Size(max = 50) @NotEmpty(message = "name cannot be null") String name,
			@Size(max = 50) String address, @Size(max = 50) String phone, @Size(max = 50) String orgId,
			boolean isActive) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.orgId = orgId;
		this.isActive = isActive;
	}
	
	//getters and setters
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

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
		
}
