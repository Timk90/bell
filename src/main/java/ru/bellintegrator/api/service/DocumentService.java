package ru.bellintegrator.api.service;

import java.util.List;

import ru.bellintegrator.api.views.DocumentView;

/**
 * сервисо списка документов
 */
public interface DocumentService {

	/**
	 * получение списка всех документов
	 * 
	 * @return
	 */
	public List<DocumentView> getAllDocumentTypes();

}
