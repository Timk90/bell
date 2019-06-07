package ru.bellintegrator.api.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.bellintegrator.api.daoCountry.CountryDao;
import ru.bellintegrator.api.daoDoc.DocDao;
import ru.bellintegrator.api.daoOffice.OfficeDao;
import ru.bellintegrator.api.daoPersonalDoc.PersonalDocDao;
import ru.bellintegrator.api.daoUser.UserDao;
import ru.bellintegrator.api.exceptions.IncorrectDateFormatException;
import ru.bellintegrator.api.exceptions.IncorrectUserDetailsException;
import ru.bellintegrator.api.exceptions.IncorretUserUpdateDataException;
import ru.bellintegrator.api.exceptions.NoSuchCountryException;
import ru.bellintegrator.api.exceptions.NoSuchDocumentException;
import ru.bellintegrator.api.exceptions.NoSuchOfficeException;
import ru.bellintegrator.api.exceptions.NoSuchUserException;
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
				user.setOffice(office);
				user.setFirstName(userView.getFirstName());
				user.setPosition(userView.getPosition());

				if (userView.getSecondName() != null) {
					user.setSecondName(userView.getSecondName());
				}
				if (userView.getMiddleName() != null) {
					user.setMiddleName(userView.getMiddleName());
				}

				if (userView.getPhone() != null) {
					user.setPhone(userView.getPhone());
				}

				if (userView.getDocName() != null) {
					List<Doc> docs = documentDao.loadByName(userView.getDocName());
					if (docs.size() > 0) {
						Doc doc = docs.get(0);
						PersonalDoc personalDoc = new PersonalDoc();
						if (userView.getDocDate() != null) {
							try {
								personalDoc.setDocDate(new SimpleDateFormat("dd-MM-yyyy").parse(userView.getDocDate()));
							} catch (ParseException e) {
								throw new IncorrectDateFormatException();
							}
						}
						personalDoc.setNumber(userView.getDocNumber());
						personalDoc.setDocument(doc);
						user.setPersonalDocument(personalDoc);
						personalDocDao.save(personalDoc);
					} else {
						throw new NoSuchDocumentException();
					}
				}
				if (userView.getCitizenshipCode() != null) {
					List<Country> countries = countryDao.loadByCode(userView.getCitizenshipCode());
					if (countries.size() > 0) {
						Country country = countries.get(0);
						user.setCitizenship(country);
					} else {
						throw new NoSuchCountryException();
					}

				}
				userDao.save(user);
			} else {
				throw new IncorrectUserDetailsException();
			}

		}
		return new SuccessView("success");
	}

	@Override
	@Transactional
	public SuccessView updateUser(UserView view) {
		if (view.getId() != null && !view.getId().equals("") && view.getFirstName() != null
				&& !view.getFirstName().equals("") && view.getPosition() != null && !view.getPosition().equals("")) {

			User user = userDao.loadById(Long.parseLong(view.getId()));
			if (user == null) {
				throw new NoSuchUserException();
			}

			PersonalDoc persDoc = personalDocDao.loadById(user.getPersonalDocument().getId());
			if (persDoc == null) {
				throw new NoSuchDocumentException();
			}

			Doc doc = documentDao.loadById(persDoc.getDocument().getId());
			if (doc == null) {
				throw new NoSuchDocumentException();
			}

			user.setFirstName(view.getFirstName());
			user.setPosition(view.getPosition());

			if (view.getSecondName() != null) {
				user.setSecondName(view.getSecondName());
			}
			if (view.getMiddleName() != null) {
				user.setMiddleName(view.getMiddleName());
			}

			if (view.getPhone() != null) {
				user.setPhone(view.getPhone());
			}

			if (view.getOfficeId() != null && !view.getOfficeId().equals("")) {
				Office office = officeDao.loadById(Long.parseLong(view.getOfficeId()));
				if (office == null) {
					throw new NoSuchOfficeException();
				}
				user.setOffice(office);
			}

			if (view.getDocName() != null && !view.getDocName().equals("")) {
				List<Doc> docs = documentDao.loadByName(view.getDocName());
				if (docs.size() > 0) {
					doc = docs.get(0);
					persDoc.setDocument(doc);
				}
			}

			if (view.getDocNumber() != null && !view.getDocNumber().equals("")) {
				persDoc.setNumber(view.getDocNumber());
			}

			if (view.getDocDate() != null && !view.getDocDate().equals("")) {
				try {
					persDoc.setDocDate(new SimpleDateFormat("dd-MM-yyyy").parse(view.getDocDate()));
				} catch (ParseException e) {
					throw new IncorrectDateFormatException();
				}
			}

			if (view.getCitizenshipCode() != null && !view.getCitizenshipCode().equals("")) {
				List<Country> countries = countryDao.loadByCode(view.getCitizenshipCode());
				if (countries.size() > 0) {
					Country country = countries.get(0);
					user.setCitizenship(country);
				} else {
					throw new NoSuchCountryException();
				}
			}
		} else {
			throw new IncorretUserUpdateDataException();
		}
		return new SuccessView("success");
	}

	@Transactional
	public static List<UserView> mapAllUsers(List<User> users) {
		List<UserView> views = new ArrayList<>();
		for (User user : users) {
			UserView view = mapUser(user);
			views.add(view);
		}
		return views;
	}

	@Transactional
	public static UserView mapUser(User user) {
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
		UserView view = new UserView(user.getId() + "", user.getFirstName(), user.getSecondName(), user.getMiddleName(),
				user.getPosition(), user.getPhone(), user.getPersonalDocument().getDocument().getName(),
				user.getPersonalDocument().getNumber(), formater.format(user.getPersonalDocument().getDocDate()),
				user.getOffice().getId() + "", user.getCitizenship().getName());
		view.setIdentified(user.isIdentified());
		return view;
	}

}
