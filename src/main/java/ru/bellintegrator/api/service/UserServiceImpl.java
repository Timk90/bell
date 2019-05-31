package ru.bellintegrator.api.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.bellintegrator.api.daoCountry.CountryDao;
import ru.bellintegrator.api.daoDoc.DocDao;
import ru.bellintegrator.api.daoOffice.OfficeDao;
import ru.bellintegrator.api.daoPersonalDoc.PersonalDocDao;
import ru.bellintegrator.api.daoUser.UserDao;
import ru.bellintegrator.api.exceptions.InsertUserException;
import ru.bellintegrator.api.model.Country;
import ru.bellintegrator.api.model.Doc;
import ru.bellintegrator.api.model.Office;
import ru.bellintegrator.api.model.Organization;
import ru.bellintegrator.api.model.PersonalDoc;
import ru.bellintegrator.api.model.User;
import ru.bellintegrator.api.views.UserView;

import java.text.ParseException;
import java.text.SimpleDateFormat;  

@Service
@Transactional
public class UserServiceImpl implements UserService {

	UserDao userDao;
	OfficeDao officeDao;
	DocDao documentDao;
	CountryDao countryDao;
	PersonalDocDao personalDocDao;
	
	@Autowired
	public UserServiceImpl(UserDao userDao, OfficeDao officeDao, DocDao documentDao, CountryDao countryDao, PersonalDocDao personalDocDao) {
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
	public void insertUser(UserView userView) {
		//Office office = officeDao.loadById(Long.parseLong(userView.getOfficeId()));
		if(userView.getOfficeId()!=null && !userView.getOfficeId().equals("")) {
			Office office = officeDao.loadById(Long.parseLong(userView.getOfficeId()));
		
			if(userView.getFirstName()!=null && !userView.getFirstName().equals("") &&
					userView.getPosition()!=null && !userView.getPosition().equals("")) {
				User user = new User();
				user.setFirstName(userView.getFirstName());
				user.setSecondName(userView.getSecondName());
				user.setMiddleName(userView.getMiddleName());
				user.setPosition(userView.getPosition());
				user.setOffice(office);
				
				String tmp = new String();
				tmp = (userView.getPhone() != null) ? userView.getPhone():""; 
				user.setPhone(tmp);
				
				//if(userView.getPersonalDocumentName()!=null && !userView.getPersonalDocumentName().equals("")) {
					List<Doc> docs = documentDao.loadByName(userView.getDocName());
					Doc doc = docs.get(0);
					PersonalDoc personalDoc = new PersonalDoc();
					try {
						personalDoc.setDocDate(new SimpleDateFormat("dd-MM-yyyy").parse(userView.getDocDate()));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					personalDoc.setNumber(userView.getDocNumber());
					personalDoc.setDocument(doc);
					user.setPersonalDocument(personalDoc);
					
					System.out.println(userView.getCitizenshipCode());
					
					
					if(userView.getCitizenshipCode()!=null) {
						List<Country> countries = countryDao.loadByCode(userView.getCitizenshipCode());
						if(countries.size()>0) {
							Country country = countries.get(0);
							user.setCitizenship(country);
							System.out.println(country.getId()+" "+country.getName()+" "+country.getCode());
						}

					}
				//}

				System.out.println(user.toString());
				personalDocDao.save(personalDoc);
				userDao.save(user);
			}

		}else {
			throw new RuntimeException();
		}
	}
	
	@Transactional
	public static List<UserView> mapAllUsers(List<User> users) {
		List<UserView> views = new ArrayList<>();
		for (User user : users) {
			String docName ="";
			String docNumber=""; 
			String docDate="";
			if(user.getPersonalDocument()!=null && !user.getPersonalDocument().equals("")) {
				docName =  user.getPersonalDocument().getDocument().getName();
				docNumber = user.getPersonalDocument().getNumber();
				docDate = user.getPersonalDocument().getDocDate().toString();
			}
			String officeId = "";
			if(user.getOffice()!=null) {
				officeId = user.getOffice().getId()+"";
			}
			String country = "";
			if(user.getCitizenship()!=null) {
				country = user.getCitizenship().getName();
			}
			views.add(new UserView(user.getId() + "", 
					user.getFirstName(), 
					user.getSecondName(), 
					user.getMiddleName(),
					user.getPosition(), 
					user.getPhone(), 
					docName, 
					docNumber,
					docDate, 
					officeId,
					country));
		}

		return views;

	}

	@Transactional
	public static UserView mapUser(User user) {
		UserView view = new UserView(user.getId() + "", 
				user.getFirstName(), 
				user.getSecondName(), 
				user.getMiddleName(),
				user.getPosition(), 
				user.getPhone(), 
				user.getPersonalDocument().getDocument().getName(), 
				user.getPersonalDocument().getNumber(),
				user.getPersonalDocument().getDocDate().toString(), 
				user.getOffice().getId()+"",
				user.getCitizenship().getName());
		return view;
	}

	
}
