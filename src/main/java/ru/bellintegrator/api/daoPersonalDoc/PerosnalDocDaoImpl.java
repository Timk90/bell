package ru.bellintegrator.api.daoPersonalDoc;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ru.bellintegrator.api.model.PersonalDoc;

@Repository
public class PerosnalDocDaoImpl implements PersonalDocDao {

	private final EntityManager em;

	/**
	 * внедрение зависимости entityManager через конструктор 
	 * @param em
	 */
	@Autowired
	public PerosnalDocDaoImpl(EntityManager em) {
		this.em = em;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<PersonalDoc> all() {
		TypedQuery<PersonalDoc> query = em.createQuery("SELECT o FROM Office o", PersonalDoc.class);
		return query.getResultList();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PersonalDoc loadById(Long id) {
		return em.find(PersonalDoc.class, id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PersonalDoc loadByName(String name) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void save(PersonalDoc personalDoc) {
		if (personalDoc.getId() == null) {
			em.persist(personalDoc);
		} else {
			em.merge(personalDoc);
		}

	}

}
