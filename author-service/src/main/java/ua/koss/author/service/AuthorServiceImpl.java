package ua.koss.author.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import ua.koss.author.entity.Author;
import ua.koss.author.mapper.AuthorMapper;
import ua.koss.author.model.AuthorDto;
import ua.koss.author.repository.AuthorRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    @Cacheable(value = "author")
    public AuthorDto findById(long id) {
        log.info(String.format("AuthorServiceImpl: findById(), parameter: %d", id));
        return AuthorMapper.INSTANCE.authorToAuthorDto(
                authorRepository.findById(id).orElse(null));
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value="author", allEntries=true),
            @CacheEvict(value="authors", allEntries=true)})
    public AuthorDto createOrUpdateAuthor(@Valid Author author) {
        log.info(String.format("AuthorServiceImpl: createOrUpdateAuthor(), parameter: %s", author));
        Author savedAuthor = authorRepository.save(author);
        return AuthorMapper.INSTANCE.authorToAuthorDto(savedAuthor);
    }

    @Override
    @Cacheable(value = "authors")
    public List<AuthorDto> findAll() {
        log.info("AuthorServiceImpl: findAll()");
        return authorRepository.findAll()
                .stream()
                .map(AuthorMapper.INSTANCE::authorToAuthorDto)
                .collect(Collectors.toList());
    }
}
