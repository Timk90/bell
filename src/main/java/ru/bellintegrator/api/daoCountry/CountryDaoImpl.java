package ru.bellintegrator.api.daoCountry;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ru.bellintegrator.api.model.Country;

@Repository
public class CountryDaoImpl implements CountryDao {

	private final EntityManager em;

	@Autowired
	public CountryDaoImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Country> all() {
		TypedQuery<Country> query = em.createQuery("SELECT c FROM Country c", Country.class);
		return query.getResultList();
	}

	@Override
	public Country loadById(Long id) {
		return em.find(Country.class, id);
	}

	@Override
	public void save(Country country) {
		em.persist(country);
	}

}
