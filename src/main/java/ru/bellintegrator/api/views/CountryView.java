package ru.bellintegrator.api.views;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * отображение страны
 */
@ApiModel(description = "страна")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CountryView {

	/**
	 * код отображения страны
	 */
	@ApiModelProperty(value = "код страны", example = "410")
	private String code;

	/**
	 * имя отображения страны
	 */
	@Size(max = 50)
	@ApiModelProperty(value = "имя", example = "Россия")
	private String name;

	public CountryView() {
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
