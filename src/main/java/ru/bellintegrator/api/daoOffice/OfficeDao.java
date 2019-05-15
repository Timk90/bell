package ru.bellintegrator.api.daoOffice;

import java.util.List;

import ru.bellintegrator.api.model.Office;

public interface OfficeDao {

	public List<Office> all();

	public Office loadById(Long id);
	
	public List<Office> loadByOrgId(Long orgId, String name, String phone, boolean isActive);

	public void save(Office office);
}
