package ua.koss.author.service;

import ua.koss.author.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User findById(long id);
    List<User> findAll();
}
