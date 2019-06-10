package ru.bellintegrator.api.daoOrganization;

import java.util.List;

import ru.bellintegrator.api.model.Organization;

/**
 * DAO для организации
 */
public interface OrganizationDao {

	/**
	 * получение списка всех организаций
	 * 
	 * @return
	 */
	public List<Organization> all();

	/**
	 * получение организации по id
	 * 
	 * @param id
	 * @return
	 */
	public Organization loadById(Long id);

	/**
	 * добавление новой организации или изменение данных уже существующей
	 * 
	 * @param organization
	 */
	public void save(Organization organization);

	public List<Organization> loadByName(String name, String inn, boolean isActive);
}
