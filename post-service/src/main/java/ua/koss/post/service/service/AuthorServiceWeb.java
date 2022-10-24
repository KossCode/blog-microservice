package ua.koss.post.service.service;

import ua.koss.post.service.dto.AuthorDto;

public interface AuthorServiceWeb {
    AuthorDto findAuthorById(String id);
}
