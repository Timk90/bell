package ru.bellintegrator.api.service;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import ru.bellintegrator.api.model.User;
import ru.bellintegrator.api.views.UserView;

@Validated
public interface UserService {
	
	/*
	 * возвращает список пользователей
	 */
	List<UserView> users();
	
	/*
	 * возвращает пользователя по id
	 */
	UserView getUserById(Long id);
	
	/*
	 * добавляет нового пользователя
	 */
	void insertUser(UserView user);
	
}
