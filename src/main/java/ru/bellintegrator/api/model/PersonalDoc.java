package ru.bellintegrator.api.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * личный документ
 */
@Entity
@Table(name = "User_document")
public class PersonalDoc {

	/**
	 * id персонального документа
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
	 * номер персонального документа
	 */
	@Column(name = "doc_number", length = 50, nullable = false)
	private String number;

	/**
	 * дата выдачи персонального документа
	 */
	@Column(name = "doc_date")
	@Temporal(TemporalType.DATE)
	private Date docDate;

	/**
	 * тип документа, связь по внешнему ключу с таблицей доступных типов документов
	 */
	@ManyToOne(fetch = FetchType.LAZY) // not to download all the data from join table.
	@JoinColumn(name = "doc_id")
	private Doc document;

	public Long getId() {
		return id;
	}

	public Doc getDocument() {
		return document;
	}

	public void setDocument(Doc document) {
		this.document = document;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getDocDate() {
		return docDate;
	}

	public void setDocDate(Date docDate) {
		this.docDate = docDate;
	}

}
