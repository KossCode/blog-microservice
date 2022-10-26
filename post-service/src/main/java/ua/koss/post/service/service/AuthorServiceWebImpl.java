package ua.koss.post.service.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ua.koss.post.service.dto.AuthorDto;

@Service
@Slf4j
public class AuthorServiceWebImpl implements AuthorServiceWeb {
    private final WebClient.Builder webClient;
    private final ReactiveCircuitBreaker authorServiceCircuitBreaker;

    @Autowired
    public AuthorServiceWebImpl(WebClient.Builder webClient, ReactiveCircuitBreakerFactory circuitBreakerFactory) {
        this.webClient = webClient;
        this.authorServiceCircuitBreaker = circuitBreakerFactory.create("authors");
    }

    @Override
    public AuthorDto findAuthorById(String id) {
        return authorServiceCircuitBreaker.run(
                webClient.build().get()
                        .uri(uriBuilder -> uriBuilder
                                .path("/authors/{id}")
                                .build(id))
                        .retrieve()
                        .bodyToMono(AuthorDto.class), throwable -> {
            log.warn("Error making request to author service", throwable.getMessage());
            return getFallbackAuthorService(id);
        }).block();
    }

    private Mono<AuthorDto> getFallbackAuthorService(String authorId) {
        return Mono.just(new AuthorDto(Long.parseLong(authorId),"not found","not found"));
    }
}
