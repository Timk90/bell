package ru.bellintegrator.api.views;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;

/**
 * отображение представления обертки объекта data
 */
@ApiModel(description = "данные")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataView {

	/**
	 * отображение данных
	 */
	private Object data;

	public DataView() {
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
