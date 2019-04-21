package ru.bellintegrator.api.service;

import java.util.List;

import ru.bellintegrator.api.daoUser.UserDao;
import ru.bellintegrator.api.model.User;

public class UserService {

	UserDao dao;

	public List<User> getAll() {

		List<User> userList = dao.all();
		return userList;
	}
}
