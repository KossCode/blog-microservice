package ua.koss.author.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.koss.author.entity.User;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();
    User findById(long id);
    User save(User user);
}
