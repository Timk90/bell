package ru.bellintegrator.api.views;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;

/**
 * представление при возникновении ошибки
 */
@ApiModel(description = "страница ошибки")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorView {

	/**
	 * текст возникшей ошибки
	 */
	private String error;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
