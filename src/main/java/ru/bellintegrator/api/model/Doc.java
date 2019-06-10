package ru.bellintegrator.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * документ
 */
@Entity
@Table(name = "Docs")
public class Doc {

	/**
	 * id документа
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
	 * код документа
	 */
	@Column(name = "code", length = 50, nullable = false)
	private String code;

	/**
	 * имя документа
	 */
	@Column(name = "name", length = 150, nullable = false)
	private String name;

	public long getId() {
		return id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
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
