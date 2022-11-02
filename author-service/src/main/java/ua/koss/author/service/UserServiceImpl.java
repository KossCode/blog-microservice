package ua.koss.author.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import ua.koss.author.entity.Author;
import ua.koss.author.entity.User;
import ua.koss.author.mapper.UserMapper;
import ua.koss.author.model.UserDto;
import ua.koss.author.repository.AuthorRepository;
import ua.koss.author.repository.UserRepository;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, AuthorRepository authorRepository) {
        this.userRepository = userRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value="user", allEntries=true)})
    public UserDto createOrUpdateUser(User user) {
        log.info(String.format("UserServiceImpl: createOrUpdateUser(), parameter: %s", user));
        user.setAuthor(checkAuthor(user.getAuthor()));
        User savedUser = userRepository.save(user);
        return UserMapper.INSTANCE.userToUserDto(savedUser);
    }

    @Override
    @Cacheable(value = "user")
    public UserDto findById(long id) {
        log.info(String.format("UserServiceImpl: findById(), parameter: %d", id));
        return UserMapper.INSTANCE.userToUserDto(
                userRepository.findById(id).orElse(null));
    }

    private Author checkAuthor(Author author) {
        if (author.getId() == null) {
            return author;
        }
        if (authorRepository.existsById(author.getId())) {
            return authorRepository.save(author);
        }
        author.setId(null);
        return author;
    }
}
