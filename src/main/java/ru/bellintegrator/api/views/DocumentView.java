package ru.bellintegrator.api.views;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * отображение документа
 */
@ApiModel(description = "отображение документа")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DocumentView {

	/**
	 * имя для отображения документа
	 */
	@ApiModelProperty(value = "название документа", example = "паспорт")
	String name;

	/**
	 * код для отображения документа
	 */
	@ApiModelProperty(value = "код документа", example = "82")
	String code;

	public DocumentView() {
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
