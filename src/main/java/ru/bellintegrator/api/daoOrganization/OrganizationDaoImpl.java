package ru.bellintegrator.api.daoOrganization;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.api.model.Organization;

@Repository
public class OrganizationDaoImpl implements OrganizationDao{

    private final EntityManager em;
	
    @Autowired
    public OrganizationDaoImpl(EntityManager em) {
        this.em = em;
    }
	
	@Override
	public List<Organization> all() {
        TypedQuery<Organization> query = em.createQuery("SELECT o FROM Organization o", Organization.class);
        return query.getResultList();
	}

	@Override
	public Organization loadById(Long id) {
        return em.find(Organization.class, id);
	}

	@Override
	public void save(Organization organization) {
        em.persist(organization);	
	}
	
}
