package ua.koss.author.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.koss.author.entity.User;
import ua.koss.author.model.UserDto;
import ua.koss.author.service.UserService;

import java.util.List;

@RestController
public class AuthController {
    
    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserDto> findAllUsers() {
        return userService.findAll();
    }
}
