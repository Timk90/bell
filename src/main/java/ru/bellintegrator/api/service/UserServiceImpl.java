package ru.bellintegrator.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ru.bellintegrator.api.daoUser.UserDao;
import ru.bellintegrator.api.model.User;

@Service
public class UserServiceImpl implements UserService {

	UserDao dao;
	
	@Override
	public List<User> users() {

		List<User> userList = dao.all();
		return userList;
	}

	@Override
	public User getUserById(long id) {
		return dao.loadById(id);
	}

	@Override
	public void insertUser(User user) {
		dao.save(user);
	}
}
