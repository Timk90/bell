package ru.bellintegrator.api.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import ru.bellintegrator.api.views.DocumentView;

public interface DocumentService {
	
	public List<DocumentView> getAllDocumentTypes();
	
}
