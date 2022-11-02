package ua.koss.author.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ua.koss.author.model.UserDto;
import ua.koss.author.service.UserService;

@RestController("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getBlogUserById(@PathVariable("id") long id) {
        log.info(String.format("AuthorController: getAuthorInformation(), parameters: %s", id));
        UserDto blogUser = userService.findById(id);
        return ResponseEntity.ok(blogUser);
    }
}
