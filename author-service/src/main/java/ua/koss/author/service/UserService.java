package ua.koss.author.service;

import ua.koss.author.entity.User;
import ua.koss.author.model.UserDto;

public interface UserService {
    UserDto createOrUpdateUser(User user);
    UserDto findById(long id);
}
