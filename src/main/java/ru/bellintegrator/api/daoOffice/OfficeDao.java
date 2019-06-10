package ru.bellintegrator.api.daoOffice;

import java.util.List;

import ru.bellintegrator.api.model.Office;

/**
 * DAO для офиса
 */
public interface OfficeDao {

	/**
	 * получение списка всех офисов
	 * 
	 * @return
	 */
	public List<Office> all();

	/**
	 * получение офиса по id
	 * 
	 * @param id
	 * @return
	 */
	public Office loadById(Long id);

	/**
	 * получение списка офисов по заданному фильтру
	 * 
	 * @param orgId
	 * @param name
	 * @param phone
	 * @param isActive
	 * @return
	 */
	public List<Office> loadByOrgId(Long orgId, String name, String phone, boolean isActive);

	/**
	 * добавление нового офиса или изменения данных уже существующего
	 * 
	 * @param office
	 */
	public void save(Office office);
}
