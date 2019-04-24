package ru.bellintegrator.api.service;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import ru.bellintegrator.api.model.User;

@Validated
public interface UserService {
	
	/*
	 * возвращает список пользователей
	 */
	List<User> users();
	
	/*
	 * возвращает пользователя по id
	 */
	User getUserById(long id);
	
	/*
	 * добавляет нового пользователя
	 */
	void insertUser(User user);
	
}
