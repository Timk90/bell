package ru.bellintegrator.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.bellintegrator.api.daoOrganization.OrganizationDao;
import ru.bellintegrator.api.model.Organization;
import ru.bellintegrator.api.views.OrganizationView;

@Service
@Transactional
public class OrganizationServiceImpl implements OrganizationService {

	private final OrganizationDao orgDao;
	
	@Autowired
	public OrganizationServiceImpl(OrganizationDao orgDao) {
		this.orgDao = orgDao;
	}
	
	@Override
	public List<OrganizationView> listOrgByName(OrganizationView view) {
		
		if(view.getName().length()!=0 || !view.getName().equals(null)) {
			List<Organization> orgs = orgDao.loadByName(view.getName(), view.getInn(), view.getIsActive());
			return mapAllOrganizations(orgs);
		}
		return null;
	}

	@Override
	public List<OrganizationView> organizations() {
		// TODO Auto-generated method stub
		return mapAllOrganizations(orgDao.all());
	}

	@Override
	public OrganizationView getOrgById(Long id) {
		// TODO Auto-generated method stub
		return mapOrganization(orgDao.loadById(id));
	}

	@Override
	public void insertOrganization(OrganizationView view) {
		// TODO Auto-generated method stub
		if(view.getName()!=null &&
		view.getFullName()!=null &&
		view.getInn()!= null && 
		view.getKpp() != null &&
		view.getAddress() != null) {
		Organization organization = new Organization();
		organization.setName(view.getName());
		organization.setFullName(view.getFullName());
		organization.setInn(view.getInn());
		organization.setKpp(view.getKpp());
		organization.setAddress(view.getAddress());
		organization.setPhone(view.getPhone());
		organization.setActive(true);
			orgDao.save(organization);
		}
	}
	
	
	
	@Override
	public void updateOrganization(OrganizationView view) {
		// TODO Auto-generated method stub
		if(view.getId()!=null &&
		view.getName()!=null &&
		view.getFullName()!=null &&
		view.getInn()!= null && 
		view.getKpp() != null &&
		view.getAddress() != null) {
		Organization organization = new Organization(Long.parseLong(view.getId()));
		organization.setName(view.getName());
		organization.setFullName(view.getFullName());
		organization.setInn(view.getInn());
		organization.setKpp(view.getKpp());
		organization.setAddress(view.getAddress());
		organization.setPhone(view.getPhone());
		organization.setActive(true);
			orgDao.save(organization);
		}
	}

	private OrganizationView mapOrganization(Organization org) {
		OrganizationView view = new OrganizationView();
		view.setId(org.getId()+"");
		view.setName(org.getName());
		view.setFullName(org.getFullName());
		view.setInn(org.getInn());
		view.setKpp(org.getKpp());
		view.setAddress(org.getAddress());
		view.setIsActive(org.isActive());
		
		return view;
	}
	
	private List<OrganizationView> mapAllOrganizations(List<Organization> orgs) {
		List<OrganizationView> views = new ArrayList<>();
		for(Organization org: orgs) {
			OrganizationView view = new OrganizationView();
			view.setId(org.getId()+"");
			view.setName(org.getName());
			//view.setFullName(org.getFullName());
			//view.setInn(org.getInn());
			//view.setKpp(org.getKpp());
			//view.setAddress(org.getAddress());
			view.setIsActive(org.isActive());
			views.add(view);
		}
		return views;
	}

}
