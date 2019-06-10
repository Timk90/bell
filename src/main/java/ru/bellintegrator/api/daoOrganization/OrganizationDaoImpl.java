package ru.bellintegrator.api.daoOrganization;

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

import ru.bellintegrator.api.model.Organization;

@Repository
public class OrganizationDaoImpl implements OrganizationDao {

	private final EntityManager em;

	/**
	 * внедрение entityManager через конструктор
	 * 
	 * @param em
	 */
	@Autowired
	public OrganizationDaoImpl(EntityManager em) {
		this.em = em;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Organization> loadByName(String name, String inn, boolean isActive) {
		CriteriaQuery<Organization> criteria = buildCriteria(name, inn, isActive);
		TypedQuery<Organization> query = em.createQuery(criteria);
		return query.getResultList();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Organization> all() {
		TypedQuery<Organization> query = em.createQuery("SELECT o FROM Organization o", Organization.class);
		return query.getResultList();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Organization loadById(Long id) {
		return em.find(Organization.class, id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void save(Organization organization) {
		if (organization.getId() == null) {
			em.persist(organization);
		} else {
			em.merge(organization);
		}
	}

	/**
	 * создание критерия для получения списка организаций по заданному фильтру
	 * 
	 * @param name
	 * @param inn
	 * @param isActive
	 * @return
	 */
	private CriteriaQuery<Organization> buildCriteria(String name, String inn, boolean isActive) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Organization> criteria = builder.createQuery(Organization.class);
		Root<Organization> org = criteria.from(Organization.class);

		List<Predicate> predicates = new ArrayList<>();
		if (name != null) {
			predicates.add(builder.equal(org.get("name"), name));
		}

		if (inn != null) {
			predicates.add(builder.equal(org.get("inn"), inn));
		}

		if (isActive == true) {
			predicates.add(builder.equal(org.get("isActive"), isActive));
		}

		criteria.where(predicates.toArray(new Predicate[] {}));
		return criteria;
	}

}
