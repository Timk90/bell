package ru.bellintegrator.api.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.bellintegrator.api.daoDoc.DocDao;
import ru.bellintegrator.api.model.Doc;
import ru.bellintegrator.api.views.DocumentView;

@Service
@Transactional
public class DocumentServiceImpl implements DocumentService {

	private final DocDao docDao;

	@Autowired
	public DocumentServiceImpl(DocDao docDao) {
		this.docDao = docDao;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<DocumentView> getAllDocumentTypes() {
		return mapAllDocuments(docDao.all());
	}

	/**
	 * Отображение объекта документа на его представление
	 * 
	 * @param doc
	 * @return
	 */
	private DocumentView mapDoc(Doc doc) {
		DocumentView dv = new DocumentView();
		dv.setCode(doc.getCode());
		dv.setName(doc.getName());
		return dv;
	}

	/**
	 * Отображение списка объектов документа на список представлений
	 * 
	 * @param docs
	 * @return
	 */
	private List<DocumentView> mapAllDocuments(List<Doc> docs) {
		List<DocumentView> views = new ArrayList<>();
		for (Doc doc : docs) {
			DocumentView dv = mapDoc(doc);
			views.add(dv);
		}
		return views;
	}
}
