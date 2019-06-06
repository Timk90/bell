package ru.bellintegrator.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.bellintegrator.api.daoOffice.OfficeDao;
import ru.bellintegrator.api.daoOrganization.OrganizationDao;
import ru.bellintegrator.api.exceptions.IncorrectIdFormatException;
import ru.bellintegrator.api.exceptions.IncorrectOfficeInsertDataException;
import ru.bellintegrator.api.exceptions.IncorrectOfficeUpdateDataException;
import ru.bellintegrator.api.exceptions.NoSuchOfficeException;
import ru.bellintegrator.api.model.Office;
import ru.bellintegrator.api.model.Organization;
import ru.bellintegrator.api.views.OfficeView;
import ru.bellintegrator.api.views.SuccessView;

@Service
@Transactional
public class OfficeServiceImpl implements OfficeService {

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
	public SuccessView insertOffice(OfficeView officeView) {
		if (officeView.getOrgId() != null && !officeView.getOrgId().equals("")) {
			try {
				Long.parseLong(officeView.getOrgId());
			} catch (NumberFormatException e) {
				throw new IncorrectIdFormatException();
			}
			Organization org = organizationDao.loadById(Long.parseLong(officeView.getOrgId()));
			Office office = new Office();

			office.setOrganization(org);
			if (officeView.getAddress() != null) {
				office.setAddress(officeView.getAddress());
			} else {
				office.setAddress("");
			}
			if (officeView.getName() != null) {
				office.setName(officeView.getName());
			} else {
				office.setName("");
			}
			if (officeView.getPhone() != null) {
				office.setPhone(officeView.getPhone());
			} else {
				office.setPhone("");
			}
			office.setActive(true);
			officeDao.save(office);
		} else {
			throw new IncorrectOfficeInsertDataException();
		}
		return new SuccessView("Success");
	}

	@Override
	public SuccessView updateOffice(OfficeView officeView) {
		if (officeView.getId() != null) {
			try {
				Long.parseLong(officeView.getId());
			} catch (NumberFormatException e) {
				throw new IncorrectIdFormatException();
			}
		}
		Office office = officeDao.loadById(Long.parseLong(officeView.getId()));
		if (office != null) {
			if (officeView.getName() != null && officeView.getAddress() != null) {
				if (officeView.getAddress() != null) {
					office.setAddress(officeView.getAddress());
				}
				if (officeView.getName() != null) {
					office.setName(officeView.getName());
				}
				if (officeView.getPhone() != null) {
					office.setPhone(officeView.getPhone());
				}
				office.setActive(officeView.isActive());
				officeDao.save(office);
			} else {
				throw new IncorrectOfficeUpdateDataException();
			}
		} else {
			throw new NoSuchOfficeException();
		}
		return new SuccessView("Success");
	}

	@Override
	public List<OfficeView> listOfficesByOrgId(OfficeView view) {
		if (view.getOrgId() != null) {
			List<Office> offices = officeDao.loadByOrgId(Long.parseLong(view.getOrgId()), view.getName(),
					view.getPhone(), view.isActive());
			return mapAllOffices(offices);
		} else {
			return null;
		}

	}

	private static OfficeView mapOffice(Office office) {
		OfficeView view = new OfficeView();
		view.setId(office.getId() + "");
		view.setName(office.getName());
		view.setAddress(office.getAddress());
		view.setPhone(office.getPhone());
		view.setOrgId(office.getOrganization().getId() + "");
		view.setActive(office.isActive());
		return view;

	}

	private static List<OfficeView> mapAllOffices(List<Office> offices) {
		List<OfficeView> views = new ArrayList<>();
		for (Office office : offices) {
			OfficeView officeView = mapOffice(office);
			views.add(officeView);
		}
		return views;

	}

}
