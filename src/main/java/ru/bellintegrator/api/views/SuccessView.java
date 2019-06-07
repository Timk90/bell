package ru.bellintegrator.api.views;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "удачное исполнение действия")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuccessView {

	String result;

	public SuccessView() {
	}

	public SuccessView(String result) {
		this.result = result;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
