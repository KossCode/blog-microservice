package ua.koss.author.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import ua.koss.author.entity.User;
import ua.koss.author.mapper.UserMapper;
import ua.koss.author.model.UserDto;
import ua.koss.author.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value="user", allEntries=true),
            @CacheEvict(value="users", allEntries=true)})
    public UserDto createOrUpdateUser(User user) {
        log.info(String.format("BlogUserServiceImpl: createUser(), parameter: %s", user));
        User savedUser = userRepository.save(user);
        return UserMapper.INSTANCE.userToUserDto(savedUser);
    }

    @Override
    @Cacheable(value = "user")
    public UserDto findById(long id) {
        log.info(String.format("BlogUserServiceImpl: findById(), parameter: %d", id));
        return UserMapper.INSTANCE.userToUserDto(
                userRepository.findById(id).orElse(null));
    }

    @Override
    public List<UserDto> findAll() {
        log.info("BlogUserServiceImpl: findAll()");
        return userRepository.findAll()
                .stream()
                .map(UserMapper.INSTANCE::userToUserDto)
                .collect(Collectors.toList());
    }
}
