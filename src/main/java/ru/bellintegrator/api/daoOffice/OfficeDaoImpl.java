package ru.bellintegrator.api.daoOffice;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ru.bellintegrator.api.model.Office;

@Repository
public class OfficeDaoImpl implements OfficeDao {
	
	@Autowired
	private EntityManager em;
	

    @Autowired
    public OfficeDaoImpl(EntityManager em) {
        this.em = em;
    }
	
	@Override
	public List<Office> all() {
		TypedQuery<Office> query = em.createQuery("SELECT o FROM Office o", Office.class);
		return query.getResultList();
	}

	@Override
	public Office loadById(Long id) {
		return em.find(Office.class, id);
	}

	@Override
	public void save(Office office) {
		em.persist(office);		
	}
	
}
