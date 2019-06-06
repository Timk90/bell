package ru.bellintegrator.api.service;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import ru.bellintegrator.api.model.Organization;
import ru.bellintegrator.api.views.OrganizationView;
import ru.bellintegrator.api.views.SuccessView;

//why should we put here @Validated
@Validated
public interface OrganizationService {
	
	/*
	 * возвращает список организаций
	 */
	List<OrganizationView> organizations();
	
	/*
	 * возвращает организацию по id
	 */
	OrganizationView getOrgById(Long id);
	
	/*
	 * добавляет новую организацию
	 */
	SuccessView insertOrganization(OrganizationView org);
	
	/*
	 * изменяет данные организации
	 */
	SuccessView updateOrganization(OrganizationView org);
	
	/*
	 * возвращает список организаций по имени
	 */
	List<OrganizationView> listOrgByName(OrganizationView name);

}
