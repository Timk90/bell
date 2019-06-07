package ru.bellintegrator.api.views;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "страница ошибки")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorView {

	private String error;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
