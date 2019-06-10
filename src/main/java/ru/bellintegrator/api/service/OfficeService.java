package ru.bellintegrator.api.service;

import java.util.List;

import ru.bellintegrator.api.views.OfficeView;
import ru.bellintegrator.api.views.SuccessView;

/**
 * сервис офиса
 */
public interface OfficeService {

	/**
	 * получить список офисов
	 * 
	 * @return
	 */
	List<OfficeView> offices();

	/**
	 * получить офис по id
	 * 
	 * @param id
	 * @return
	 */
	OfficeView getOfficeById(Long id);

	/**
	 * добавить новый офис
	 * 
	 * @param office
	 * @return
	 */
	SuccessView insertOffice(OfficeView office);

	/**
	 * изменить данные офиса
	 * 
	 * @param office
	 * @return
	 */
	SuccessView updateOffice(OfficeView office);

	/**
	 * получить список офисов по ID организации
	 * 
	 * @param view
	 * @return
	 */
	List<OfficeView> listOfficesByOrgId(OfficeView view);

}
