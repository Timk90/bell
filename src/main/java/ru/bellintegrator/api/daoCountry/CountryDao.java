package ru.bellintegrator.api.daoCountry;

import java.util.List;

import ru.bellintegrator.api.model.Country;

/**
 * DAO для работы со страной
 */
public interface CountryDao {

	/**
	 * получить список всех стран
	 * 
	 * @return
	 */
	public List<Country> all();

	/**
	 * получить страну по id
	 * 
	 * @param id
	 * @return
	 */
	public Country loadById(Long id);

	/**
	 * загрузить список стран соответствующих указанному коду страны
	 * 
	 * @param code
	 * @return
	 */
	public List<Country> loadByCode(String code);

	/**
	 * сохранить новый офис или изменить данные существующего
	 * 
	 * @param office
	 */
	public void save(Country office);
}
