package ru.bellintegrator.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.bellintegrator.api.daoUser.UserDao;
import ru.bellintegrator.api.model.User;

@Service
public class UserServiceImpl implements UserService {

	UserDao dao;
	
	@Autowired
	public UserServiceImpl(UserDao dao) {
		this.dao = dao;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<User> users() {

		List<User> userList = dao.all();
		return userList;
	}

	@Override
	@Transactional
	public User getUserById(Long id) {
		return dao.loadById(id);
	}

	@Override
	@Transactional
	public void insertUser(User user) {
		dao.save(user);
	}
}
