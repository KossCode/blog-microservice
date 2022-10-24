package ua.koss.post.service.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import ua.koss.post.service.dto.AuthorDto;

@Service
@Slf4j
public class AuthorServiceWebImpl implements AuthorServiceWeb {
    private final WebClient.Builder webClient;

    @Autowired
    public AuthorServiceWebImpl(WebClient.Builder webClient) {
        this.webClient = webClient;
    }

    @Override
    public AuthorDto findAuthorById(String id) {
        AuthorDto authorDto = null;
        try {
            authorDto = webClient
                    .build()
                    .get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/authors/{id}")
                            .build(id))
                    .retrieve()
                    .bodyToMono(AuthorDto.class)
                    .block();
        } catch (WebClientRequestException | WebClientResponseException e) {
            log.error(String.format("AuthorServiceWebImpl: findAuthorById -> %s ", e.getMessage()));
        }
        return authorDto;
    }
}
