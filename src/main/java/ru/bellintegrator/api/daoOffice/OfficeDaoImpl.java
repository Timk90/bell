package ru.bellintegrator.api.daoOffice;

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

import ru.bellintegrator.api.model.Office;

@Repository
public class OfficeDaoImpl implements OfficeDao {

	private final EntityManager em;

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
	public List<Office> loadByOrgId(Long orgId, String name, String phone, boolean isActive) {
		CriteriaQuery<Office> criteria = buildCriteria(orgId, name, phone, isActive);
		TypedQuery<Office> query = em.createQuery(criteria);
		return query.getResultList();

	}

	@Override
	public void save(Office office) {
		if (office.getId() == null) {
			em.persist(office);
		} else {
			em.merge(office);
		}
	}

	private CriteriaQuery<Office> buildCriteria(Long orgId, String name, String phone, boolean isActive) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Office> criteria = builder.createQuery(Office.class);
		Root<Office> org = criteria.from(Office.class);

		List<Predicate> predicates = new ArrayList<>();
		if (orgId != null) {
			predicates.add(builder.equal(org.get("organization").get("id"), orgId));
		}
		if (name != null) {
			predicates.add(builder.equal(org.get("name"), name));
		}
		if (phone != null) {
			predicates.add(builder.equal(org.get("phone"), phone));
		}
		if (isActive == true) {
			predicates.add(builder.equal(org.get("isActive"), isActive));
		}
		criteria.where(predicates.toArray(new Predicate[] {}));
		return criteria;
	}

}
