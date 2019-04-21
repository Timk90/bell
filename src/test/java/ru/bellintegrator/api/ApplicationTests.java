package ru.bellintegrator.api;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import ru.bellintegrator.api.daoCountry.CountryDao;
import ru.bellintegrator.api.daoDoc.DocDao;
import ru.bellintegrator.api.daoOffice.OfficeDao;
import ru.bellintegrator.api.daoOrganization.OrganizationDao;
import ru.bellintegrator.api.daoUser.UserDao;
import ru.bellintegrator.api.model.Country;
import ru.bellintegrator.api.model.Doc;
import ru.bellintegrator.api.model.Office;
import ru.bellintegrator.api.model.Organization;
import ru.bellintegrator.api.model.PersonalDoc;
import ru.bellintegrator.api.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class })
@Transactional // After I added this LazyInitializationException disappeared
public class ApplicationTests {

	@Autowired
	UserDao userDao;

	@Autowired
	OfficeDao officeDao;

	@Autowired
	OrganizationDao organizationDao;

	@Autowired
	DocDao docDao;

	@Autowired
	CountryDao countryDao;

	// @Autowired
	// UserService userService;

	@Test
	public void contextLoads() {

	}

	// @Test(expected=LazyInitializationException.class)
	@Test
	public void checkAllUsers() {
		List<User> users = userDao.all();

		System.out.println("------------Records from User table-------------");
		for (User user : users) {
			// Hibernate.initialize(user.getPersonalDocument());
			// Hibernate.initialize(user.getPersonalDocumentDetails());
			PersonalDoc persDoc = user.getPersonalDocumentDetails();
			Doc doctype = persDoc.getDocument();
			Country citizenship = user.getCitizenship();

			System.out.println(user.getId() + "," + user.getFirstName() + "," + user.getMiddleName() + ","
					+ user.getPhone() + "," + user.getPosition() + "," + user.getSecondName() + "," + doctype.getCode()
					+ "," + doctype.getName() + "," + persDoc.getNumber() + "," + persDoc.getDocDate() + ","
					+ citizenship.getCode() + "," + citizenship.getName());
		}
		System.out.println("------------------------------------------------");

	}

	@Test
	public void checkAllOffices() {
		List<Office> offices = officeDao.all();

		System.out.println("------------Records from Office table-------------");
		for (Office office : offices) {
			Organization org = office.getOrganization();

			System.out.println(office.getId() + "," + office.getAddress() + "," + office.getName() + ","
					+ office.getPhone() + "," + org.getAddress() + "," + org.getFullName() + "," + org.getId() + ","
					+ org.getKpp() + "," + org.getName() + "," + org.getPhone() + ",");
			for (Office tmpOffice : org.getOffices()) {
				System.out.println("Office name:" + tmpOffice.getId() + ":" + tmpOffice.getName());
			}
		}
		System.out.println("------------------------------------------------");

	}

	@Test
	public void checkAllOrganizations() {
		List<Organization> orgs = organizationDao.all();
		List<Office> offices;

		System.out.println("------------Records from Organization table-------------");
		for (Organization org : orgs) {
			offices = org.getOffices();

			System.out.println(org.getId() + "," + org.getAddress() + "," + org.getFullName() + "," + org.getId() + ","
					+ org.getKpp() + "," + org.getName() + "," + org.getPhone() + ",");
			for (Office tmpOffice : offices) {
				System.out.println("Office name:" + tmpOffice.getId() + ":" + tmpOffice.getName());
			}
		}

		System.out.println("------------------------------------------------");

	}

	@Test
	public void checkAllDocsAndCountries() {
		List<Doc> docs = docDao.all();
		List<Country> countries = countryDao.all();
		System.out.println("-----------------Countries----------------------");
		for (Country c : countries) {
			System.out.println("id:" + c.getId() + ", Name:" + c.getName());
		}
		System.out.println("------------------------------------------------");
		System.out.println("-----------------Documents----------------------");
		for (Doc d : docs) {
			System.out.println("id:" + d.getId() + ", Name:" + d.getName() + ", code:" + d.getCode());
		}
		System.out.println("------------------------------------------------");
	}
}
