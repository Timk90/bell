package ru.bellintegrator.api.daoDoc;

import java.util.List;

import ru.bellintegrator.api.model.Doc;

public interface DocDao {

	public List<Doc> all();

	public Doc loadById(Long id);

	public void save(Doc doc);

}
