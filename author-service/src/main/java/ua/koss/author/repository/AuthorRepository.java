package ua.koss.author.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.koss.author.entity.Author;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface AuthorRepository extends CrudRepository<Author, Long> {
    List<Author> findAll();
    Optional<Author> findById(Long id);
    Author save(Author author);
}
