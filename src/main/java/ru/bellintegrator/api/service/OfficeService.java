package ru.bellintegrator.api.service;

import java.util.List;

import ru.bellintegrator.api.views.OfficeView;
import ru.bellintegrator.api.views.SuccessView;

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
	SuccessView insertOffice(OfficeView office);
	
	/*
	 * изменяет данные офиса
	 */
	SuccessView updateOffice(OfficeView office);
	
	/*
	 * возвращает список офисов по ID организации
	 */
	List<OfficeView> listOfficesByOrgId(OfficeView view);

}
