package ru.bellintegrator.api.daoOrganization;

import java.util.List;
import ru.bellintegrator.api.model.Organization;


public interface OrganizationDao {
    
    public List<Organization> all();

    public Organization loadById(Long id);
    
    public void save(Organization organization);
}
