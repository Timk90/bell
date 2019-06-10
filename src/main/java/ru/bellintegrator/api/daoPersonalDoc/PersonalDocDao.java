package ru.bellintegrator.api.daoPersonalDoc;

import java.util.List;

import ru.bellintegrator.api.model.PersonalDoc;

/**
 * DAO для персонального документа сотрудника
 */
public interface PersonalDocDao {

	/**
	 * получение списка всех документов всех сотрудников
	 * 
	 * @return
	 */
	public List<PersonalDoc> all();

	/**
	 * получение документа по заданному id
	 * 
	 * @param id
	 * @return
	 */
	public PersonalDoc loadById(Long id);

	/**
	 * получение документа по заданному имени
	 * 
	 * @param name
	 * @return
	 */
	public PersonalDoc loadByName(String name);

	/**
	 * добавление нового личного документа или изменение данных уже существующего
	 * 
	 * @param personalDoc
	 */
	public void save(PersonalDoc personalDoc);

}
