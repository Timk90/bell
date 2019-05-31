package ru.bellintegrator.api.daoPersonalDoc;

import java.util.List;

import ru.bellintegrator.api.model.PersonalDoc;

public interface PersonalDocDao {
	
	public List<PersonalDoc> all();

	public PersonalDoc loadById(Long id);

	public void save(PersonalDoc personalDoc);
	
}
