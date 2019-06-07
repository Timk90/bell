package ru.bellintegrator.api.daoCountry;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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

	@Override
	public List<Country> loadByCode(String code) {
		CriteriaQuery<Country> criteria = buildCriteria(code);
		TypedQuery<Country> query = em.createQuery(criteria);
		return query.getResultList();
	}

	private CriteriaQuery<Country> buildCriteria(String code) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Country> criteria = builder.createQuery(Country.class);
		Root<Country> org = criteria.from(Country.class);

		List<Predicate> predicates = new ArrayList<>();
		if (code != null) {
			predicates.add(builder.equal(org.get("code"), code));
		}

		criteria.where(predicates.toArray(new Predicate[] {}));
		return criteria;
	}

}
