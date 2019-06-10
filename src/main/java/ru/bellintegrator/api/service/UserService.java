package ru.bellintegrator.api.service;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import ru.bellintegrator.api.views.SuccessView;
import ru.bellintegrator.api.views.UserView;

@Validated
public interface UserService {

	/**
	 * возвращает список пользователей
	 * 
	 * @return
	 */
	List<UserView> users();

	/**
	 * возвращает пользователя по id
	 *
	 * @param id
	 * @return
	 */
	UserView getUserById(Long id);

	/**
	 * добавляет нового пользователя
	 *
	 * @param user
	 * @return
	 */
	SuccessView insertUser(UserView user);

	/**
	 * изменить запись пользователя
	 *
	 * @param user
	 * @return
	 */
	SuccessView updateUser(UserView user);
}
