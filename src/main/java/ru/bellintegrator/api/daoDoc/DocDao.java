package ru.bellintegrator.api.daoDoc;

import java.util.List;

import ru.bellintegrator.api.model.Doc;

public interface DocDao {

	public List<Doc> all();

	public Doc loadById(Long id);
	
	public List<Doc> loadByName(String name);
	
	public List<Doc> loadByCode(String code);

	public void save(Doc doc);

}
