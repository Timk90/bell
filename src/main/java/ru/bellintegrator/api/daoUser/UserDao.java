package ru.bellintegrator.api.daoUser;

import java.util.List;

import ru.bellintegrator.api.model.User;

public interface UserDao {
    
    public List<User> all();

    public User loadById(Long id);
    
    public void save(User user);
}
