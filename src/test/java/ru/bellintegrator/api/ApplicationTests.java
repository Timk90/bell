package ru.bellintegrator.api;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ru.bellintegrator.api.daoUser.UserDao;
import ru.bellintegrator.api.model.Country;
import ru.bellintegrator.api.model.Doc;
import ru.bellintegrator.api.model.PersonalDoc;
import ru.bellintegrator.api.model.User;
import ru.bellintegrator.api.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class ApplicationTests {
	
	@Autowired
	UserDao userDao;
	
	//@Autowired
	//UserService userService;
	
	@Test
	public void contextLoads() {
		
	}
	
	@Test
	public void checkAllUsers() {
		List<User> users = userDao.all();
		
		System.out.println("------------Records from User table-------------");
		for(User user : users) {
			Doc doc = user.getDocument();
			PersonalDoc persDoc = user.getPersonalDocumentDetails();
			Country citizenship = user.getCitizenship();

			System.out.println(user.getId()+","+
			                   user.getFirstName()+","+
					           user.getMiddleName()+","+
			                   user.getPhone()+","+
					           user.getPosition()+","+
			                   user.getSecondName()+","+
					           doc.getCode()+","+
			                   doc.getName()+","+
					           persDoc.getNumber()+","+
			                   persDoc.getDocDate()+","+
					           citizenship.getCode()+","+
			                   citizenship.getName()
					          );
		}
		System.out.println("------------------------------------------------");
		
	}
}
