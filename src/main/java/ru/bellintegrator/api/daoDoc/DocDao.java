package ru.bellintegrator.api.daoDoc;

import java.util.List;

import ru.bellintegrator.api.model.Doc;

/**
 * DAO для документа
 */
public interface DocDao {

	/**
	 * получить список всех офисов
	 * 
	 * @return
	 */
	public List<Doc> all();

	/**
	 * получить документ по id
	 * 
	 * @param id
	 * @return
	 */
	public Doc loadById(Long id);

	/**
	 * получить документ по имени
	 * 
	 * @param name
	 * @return
	 */
	public List<Doc> loadByName(String name);

	/**
	 * получить документ по коду
	 * 
	 * @param code
	 * @return
	 */
	public List<Doc> loadByCode(String code);

	/**
	 * добавить новый или изменить существующий документ
	 * 
	 * @param doc
	 */
	public void save(Doc doc);

}
