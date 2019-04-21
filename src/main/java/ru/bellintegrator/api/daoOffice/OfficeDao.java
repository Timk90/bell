package ru.bellintegrator.api.daoOffice;

import java.util.List;

import ru.bellintegrator.api.model.Office;

public interface OfficeDao {

	public List<Office> all();

	public Office loadById(Long id);

	public void save(Office office);
}
