package ru.bellintegrator.api.service;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import ru.bellintegrator.api.views.OrganizationView;
import ru.bellintegrator.api.views.SuccessView;

@Validated
public interface OrganizationService {

	/**
	 * возвращает список организаций
	 * 
	 * @return
	 */
	List<OrganizationView> organizations();

	/**
	 * возвращает организацию по id
	 * 
	 * @param id
	 * @return
	 */
	OrganizationView getOrgById(Long id);

	/**
	 * добавляет новую организацию
	 * 
	 * @param org
	 * @return
	 */
	SuccessView insertOrganization(OrganizationView org);

	/**
	 * изменяет данные организации
	 * 
	 * @param org
	 * @return
	 */
	SuccessView updateOrganization(OrganizationView org);

	/**
	 * возвращает список организаций по имени
	 * 
	 * @param name
	 * @return
	 */
	List<OrganizationView> listOrgByName(OrganizationView name);

}
