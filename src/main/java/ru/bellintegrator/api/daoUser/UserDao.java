package ru.bellintegrator.api.daoUser;

import java.util.List;

import ru.bellintegrator.api.model.User;

/**
 * DAO для сотрудника
 */
public interface UserDao {

	/**
	 * получение списка всех сотрудников
	 * 
	 * @return
	 */
	public List<User> all();

	/**
	 * получение сотрудника по заданному id
	 * 
	 * @param id
	 * @return
	 */
	public User loadById(Long id);

	/**
	 * добавление нового сотрудника или изменение данных уже существующего
	 * 
	 * @param user
	 */
	public void save(User user);
}
