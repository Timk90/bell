package ru.bellintegrator.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.bellintegrator.api.daoUser.UserDao;
import ru.bellintegrator.api.model.User;
import ru.bellintegrator.api.views.UserView;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	UserDao dao;
	
	@Autowired
	public UserServiceImpl(UserDao dao) {
		this.dao = dao;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<UserView> users() {
		List<User> userList = dao.all();
		return this.mapAllUsers(userList);
	}

	@Override
	@Transactional
	public UserView getUserById(Long id) {
		return this.mapUser(dao.loadById(id));
	}

	@Override
	@Transactional
	public void insertUser(User user) {
		dao.save(user);
	}
	
	@Transactional
	public static List<UserView> mapAllUsers(List<User> users) {
		List<UserView> views = new ArrayList<>();
		for (User user : users) {
			views.add(new UserView(user.getId() + "", 
					user.getFirstName(), 
					user.getSecondName(), 
					user.getMiddleName(),
					user.getPosition(), 
					user.getPhone(), 
					user.getPersonalDocument().getDocument().getName(), 
					user.getPersonalDocument().getNumber(),
					user.getPersonalDocument().getDocDate().toString(), 
					user.getOffice().getId()+"",
					user.getCitizenship().getName()));
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
