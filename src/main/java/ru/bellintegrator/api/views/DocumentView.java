package ru.bellintegrator.api.views;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "отображение документа")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DocumentView {

	@ApiModelProperty(value = "название документа", example = "паспорт")
	String name;

	@ApiModelProperty(value = "код документа", example = "82")
	String code;

	public DocumentView() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
