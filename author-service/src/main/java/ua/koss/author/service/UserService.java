package ua.koss.author.service;

import ua.koss.author.entity.User;
import ua.koss.author.model.UserDto;

import java.util.List;

public interface UserService {
    UserDto createOrUpdateUser(User user);
    UserDto findById(long id);
    List<UserDto> findAll();
}
