package ru.bellintegrator.api.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import ru.bellintegrator.api.daoCountry.CountryDao;
import ru.bellintegrator.api.daoDoc.DocDao;
import ru.bellintegrator.api.daoOffice.OfficeDao;
import ru.bellintegrator.api.daoPersonalDoc.PersonalDocDao;
import ru.bellintegrator.api.daoUser.UserDao;
import ru.bellintegrator.api.exceptions.IncorrectDateFormatException;
import ru.bellintegrator.api.exceptions.IncorretadUserUpdateDataException;
import ru.bellintegrator.api.exceptions.NoSuchCountryException;
import ru.bellintegrator.api.exceptions.NoSuchDocumentException;
import ru.bellintegrator.api.exceptions.NoSuchOfficeException;
import ru.bellintegrator.api.exceptions.NoSuchUSerException;
import ru.bellintegrator.api.exceptions.UserDetailsInsertException;
import ru.bellintegrator.api.model.Country;
import ru.bellintegrator.api.model.Doc;
import ru.bellintegrator.api.model.Office;
import ru.bellintegrator.api.model.PersonalDoc;
import ru.bellintegrator.api.model.User;
import ru.bellintegrator.api.views.SuccessView;
import ru.bellintegrator.api.views.UserView;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	UserDao userDao;
	OfficeDao officeDao;
	DocDao documentDao;
	CountryDao countryDao;
	PersonalDocDao personalDocDao;

	@Autowired
	public UserServiceImpl(UserDao userDao, OfficeDao officeDao, DocDao documentDao, CountryDao countryDao,
			PersonalDocDao personalDocDao) {
		this.userDao = userDao;
		this.officeDao = officeDao;
		this.documentDao = documentDao;
		this.countryDao = countryDao;
		this.personalDocDao = personalDocDao;
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserView> users() {
		List<User> userList = userDao.all();
		return mapAllUsers(userList);
	}

	@Override
	@Transactional
	public UserView getUserById(Long id) {
		return mapUser(userDao.loadById(id));
	}

	@Override
	@Transactional
	public SuccessView insertUser(UserView userView) {

		if (userView.getOfficeId() != null && !userView.getOfficeId().equals("")) {
			Office office = officeDao.loadById(Long.parseLong(userView.getOfficeId()));
			if (office == null) {
				throw new NoSuchOfficeException();
			}
			if (userView.getFirstName() != null && !userView.getFirstName().equals("") && userView.getPosition() != null
					&& !userView.getPosition().equals("")) {

				User user = new User();
				user.setFirstName(userView.getFirstName());
				user.setSecondName(userView.getSecondName());
				user.setMiddleName(userView.getMiddleName());
				user.setPosition(userView.getPosition());
				user.setOffice(office);

				String tmp = new String();
				tmp = (userView.getPhone() != null) ? userView.getPhone() : "";
				user.setPhone(tmp);
				List<Doc> docs = documentDao.loadByName(userView.getDocName());
				if (docs.size() > 0) {
					Doc doc = docs.get(0);

					PersonalDoc personalDoc = new PersonalDoc();
					try {
						personalDoc.setDocDate(new SimpleDateFormat("dd-MM-yyyy").parse(userView.getDocDate()));
					} catch (ParseException e) {
						personalDoc.setDocDate(null);
					}
					personalDoc.setNumber(userView.getDocNumber());
					personalDoc.setDocument(doc);
					user.setPersonalDocument(personalDoc);
					System.out.println(userView.getCitizenshipCode());
					personalDocDao.save(personalDoc);
				}
				if (userView.getCitizenshipCode() != null) {
					List<Country> countries = countryDao.loadByCode(userView.getCitizenshipCode());
					if (countries.size() > 0) {
						Country country = countries.get(0);
						user.setCitizenship(country);
					}

				}
				System.out.println(user.toString());
				userDao.save(user);
			} else {
				throw new UserDetailsInsertException();
			}

		}	
		return new SuccessView("success");
	}
	
	
	@Override
	@Transactional
	public SuccessView updateUser(UserView view) {
		if(view.getId()!=null && view.getFirstName()!=null && view.getPosition()!=null) {
			User user = userDao.loadById(Long.parseLong(view.getId()));
			if(user==null) {
				throw new NoSuchUSerException();
			}
			user.setFirstName(view.getFirstName());
			user.setMiddleName(view.getMiddleName());
			user.setSecondName(view.getSecondName());
			if(view.getOfficeId()!=null && !view.getOfficeId().equals("")) {
				Office office = officeDao.loadById(Long.parseLong(view.getOfficeId()));
				if(office == null) {
					throw new NoSuchOfficeException();
				}
			user.setOffice(office);
			}else {
				user.setOffice(null);
			}
			
			user.setPosition(view.getPosition());
			user.setPhone(view.getPhone());
			
			PersonalDoc persDoc = personalDocDao.loadById(user.getPersonalDocument().getId());
			Doc doc = documentDao.loadById(persDoc.getDocument().getId());
			String newDocName = (view.getDocName()!=null && !view.getDocName().equals("")) ? view.getDocName() : "";
			String newDocNumber = (view.getDocNumber()!=null && !view.getDocNumber().equals("")) ? view.getDocNumber() : "";
			String newDocDate = (view.getDocDate()!=null && !view.getDocDate().equals("")) ? view.getDocDate() : "";
			
			persDoc.setNumber(newDocNumber);
			try {
				persDoc.setDocDate(new SimpleDateFormat("dd-MM-yyyy").parse(newDocDate));
			} catch (ParseException e) {
				throw new IncorrectDateFormatException();
			}
			
			if(view.getDocName()!=null && !view.getDocName().equals("")) {
				List<Doc> newDocs = documentDao.loadByName(newDocName);
				if(newDocs.size()>0) {
					Doc newDoc = newDocs.get(0);
					doc.setCode(newDoc.getCode());
					doc.setName(newDoc.getName());	
				}else {
					throw new NoSuchDocumentException();
				}		
			}
			
			if(view.getCitizenshipCode()!=null && !view.getCitizenshipCode().equals("")) {
				List<Country> countries = countryDao.loadByCode(view.getCitizenshipCode());
				if(countries.size()>0) {
					Country country = countries.get(0);
					user.setCitizenship(country);
				}else {
					throw new NoSuchCountryException();
				}
			}
			
		}else {
			throw new IncorretadUserUpdateDataException();
		}
		return new SuccessView("success");
	}

	@Transactional
	public static List<UserView> mapAllUsers(List<User> users) {
		List<UserView> views = new ArrayList<>();
		for (User user : users) {
			String docName = "";
			String docNumber = "";
			String docDate = "";
			if (user.getPersonalDocument() != null && !user.getPersonalDocument().equals("")) {
				docName = user.getPersonalDocument().getDocument().getName();
				docNumber = user.getPersonalDocument().getNumber();
				docDate = user.getPersonalDocument().getDocDate().toString();
			}
			String officeId = "";
			if (user.getOffice() != null) {
				officeId = user.getOffice().getId() + "";
			}
			String country = "";
			if (user.getCitizenship() != null) {
				country = user.getCitizenship().getName();
			}
			UserView view = new UserView(user.getId() + "", user.getFirstName(), user.getSecondName(), user.getMiddleName(),
					user.getPosition(), user.getPhone(), docName, docNumber, docDate, officeId, country);
			view.setIdentified(user.isIdentified());
			views.add(view);
		}

		return views;

	}

	@Transactional
	public static UserView mapUser(User user) {
		UserView view = new UserView(user.getId() + "", user.getFirstName(), user.getSecondName(), user.getMiddleName(),
				user.getPosition(), user.getPhone(), user.getPersonalDocument().getDocument().getName(),
				user.getPersonalDocument().getNumber(), user.getPersonalDocument().getDocDate().toString(),
				user.getOffice().getId() + "", user.getCitizenship().getName());
		view.setIdentified(user.isIdentified());
		return view;
	}

}
