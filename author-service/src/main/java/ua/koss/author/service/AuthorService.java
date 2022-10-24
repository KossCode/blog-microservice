package ua.koss.author.service;

import ua.koss.author.entity.Author;
import ua.koss.author.model.AuthorDto;

import java.util.List;

public interface AuthorService {
    List<AuthorDto> findAll();
    AuthorDto findById(long id);
    AuthorDto createOrUpdateAuthor(Author author);
}
