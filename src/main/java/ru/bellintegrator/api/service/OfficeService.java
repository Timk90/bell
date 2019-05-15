package ru.bellintegrator.api.service;

import java.util.List;

import ru.bellintegrator.api.views.OfficeView;

public interface OfficeService {
	
	/*
	 * возвращает список офисов
	 */
	List<OfficeView> offices();
	
	/*
	 * возвращает офис по id
	 */
	OfficeView getOfficeById(Long id);
	
	/*
	 * добавляет новый офис 
	 */
	void insertOffice(OfficeView office);
	
	/*
	 * изменяет данные офиса
	 */
	void updateOffice(OfficeView office);
	
	/*
	 * возвращает список офисов по ID организации
	 */
	List<OfficeView> listOfficesByOrgId(OfficeView view);

}
