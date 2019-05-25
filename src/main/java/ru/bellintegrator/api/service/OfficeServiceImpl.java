package ru.bellintegrator.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.api.daoOffice.OfficeDao;
import ru.bellintegrator.api.daoOrganization.OrganizationDao;
import ru.bellintegrator.api.model.Office;
import ru.bellintegrator.api.model.Organization;
import ru.bellintegrator.api.views.OfficeView;

@Service
@Transactional
public class OfficeServiceImpl implements OfficeService{
	
	private final OfficeDao officeDao;
	private final OrganizationDao organizationDao;
	
	@Autowired
	public OfficeServiceImpl(OfficeDao officeDao, OrganizationDao organizationDao) {
		this.officeDao = officeDao;
		this.organizationDao = organizationDao;
	}

	@Override
	public List<OfficeView> offices() {
		// TODO Auto-generated method stub
		List<Office> offices = officeDao.all();		
		return mapAllOffices(offices);
	}


	@Override
	public OfficeView getOfficeById(Long id) {
		Office office = officeDao.loadById(id);
		return mapOffice(office);
	}

	@Override
	public void insertOffice(OfficeView officeView) {
		// TODO Auto-generated method stub
		if(officeView.getOrgId()!=null) {
			Organization org = organizationDao.loadById(Long.parseLong(officeView.getOrgId()));
			Office tmpOffice = new Office();
			String tmp = new String();
			tmpOffice.setOrganization(org);
			tmp = (officeView.getAddress()!=null) ? officeView.getAddress(): ""; 
			tmpOffice.setAddress(tmp);
			tmp = (officeView.getName()!=null) ? officeView.getName(): "";
			tmpOffice.setName(officeView.getName());
			tmpOffice.setPhone(officeView.getPhone());
			tmpOffice.setActive(true);
			officeDao.save(tmpOffice);
		}
	}

	@Override
	public void updateOffice(OfficeView office) {
		// TODO Auto-generated method stub
		Office tmpOffice = officeDao.loadById(Long.parseLong(office.getId()));
		if(tmpOffice.getId()!=null && !tmpOffice.getId().equals("") &&
				office.getId()!=null && !office.getId().equals("") && 
				office.getName()!=null && !office.getName().equals("") &&
				office.getAddress()!=null && !office.getAddress().equals("")) {
			tmpOffice.setName(office.getName());
			tmpOffice.setAddress(office.getAddress());
			tmpOffice.setPhone(office.getPhone());
			tmpOffice.setActive(true);
			officeDao.save(tmpOffice);
		}
	}

	@Override
	public List<OfficeView> listOfficesByOrgId(OfficeView view) {
		// TODO Auto-generated method stub
		
		if(view.getOrgId() != null) {
			List<Office> offices = officeDao.loadByOrgId(Long.parseLong(view.getOrgId()), view.getName(), view.getPhone(), view.isActive());
			return mapAllOfficesShort(offices);
		}else {
			return null;
		}
		
	}
	
	private static OfficeView mapOffice(Office office){
		OfficeView view = new OfficeView();
		view.setId(office.getId()+"");
		view.setName(office.getName());
		view.setAddress(office.getAddress());
		view.setPhone(office.getPhone());
		view.setOrgId(office.getOrganization().getId()+"");
		return view;
		
	}
	
	private static List<OfficeView> mapAllOffices(List<Office> offices){
		List<OfficeView> views = new ArrayList<>();
		for(Office office: offices) {
			OfficeView view = new OfficeView();
			view.setId(office.getId()+"");
			view.setName(office.getName());
			view.setAddress(office.getAddress());
			view.setPhone(office.getPhone());
			view.setOrgId(office.getOrganization().getId()+"");
			views.add(view);
		}
		return views;
		
	}
	
	private static List<OfficeView> mapAllOfficesShort(List<Office> offices){
		List<OfficeView> views = new ArrayList<>();
		for(Office office: offices) {
			OfficeView view = new OfficeView();
			view.setId(office.getId()+"");
			view.setOrgId(office.getOrganization().getId()+"");
			view.setName(office.getName());
			view.setActive(office.isActive());
			//view.setAddress(office.getAddress());
			//view.setPhone(office.getPhone());
			views.add(view);
		}
		return views;
		
	}

}
