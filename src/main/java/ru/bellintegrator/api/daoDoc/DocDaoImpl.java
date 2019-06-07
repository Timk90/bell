package ru.bellintegrator.api.daoDoc;

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

import ru.bellintegrator.api.model.Doc;

@Repository
public class DocDaoImpl implements DocDao {

	private final EntityManager em;

	@Autowired
	public DocDaoImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Doc> all() {
		TypedQuery<Doc> query = em.createQuery("SELECT d FROM Doc d", Doc.class);
		return query.getResultList();
	}

	@Override
	public Doc loadById(Long id) {
		return em.find(Doc.class, id);
	}

	@Override
	public List<Doc> loadByName(String name) {
		CriteriaQuery<Doc> criteria = buildCriteriaName(name);
		TypedQuery<Doc> query = em.createQuery(criteria);
		return query.getResultList();
	}

	@Override
	public List<Doc> loadByCode(String code) {
		CriteriaQuery<Doc> criteria = buildCriteriaCode(code);
		TypedQuery<Doc> query = em.createQuery(criteria);
		return query.getResultList();
	}

	@Override
	public void save(Doc doc) {
		em.persist(doc);
	}

	private CriteriaQuery<Doc> buildCriteriaName(String name) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Doc> criteria = builder.createQuery(Doc.class);
		Root<Doc> doc = criteria.from(Doc.class);

		List<Predicate> predicates = new ArrayList<>();
		if (name != null) {
			predicates.add(builder.equal(doc.get("name"), name));
		}

		criteria.where(predicates.toArray(new Predicate[] {}));
		return criteria;
	}

	private CriteriaQuery<Doc> buildCriteriaCode(String code) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Doc> criteria = builder.createQuery(Doc.class);
		Root<Doc> org = criteria.from(Doc.class);

		List<Predicate> predicates = new ArrayList<>();
		if (code != null) {
			predicates.add(builder.equal(org.get("code"), code));
		}

		criteria.where(predicates.toArray(new Predicate[] {}));
		return criteria;
	}

}
