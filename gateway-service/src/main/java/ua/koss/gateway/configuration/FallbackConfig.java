package ua.koss.gateway.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import ua.koss.gateway.model.Author;

@Configuration
public class FallbackConfig {

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions
                .route(RequestPredicates.GET("/author-fallback"), this::handleGetFallback)
                .andRoute(RequestPredicates.POST("/author-fallback"), this::handlePostFallback)
                .andRoute(RequestPredicates.GET("/post-fallback"), this::handleGetPostFallback)
                .andRoute(RequestPredicates.POST("/post-fallback"), this::handlePostPostFallback);
    }

    public Mono<ServerResponse> handleGetFallback(ServerRequest request) {
        return ServerResponse.ok().body(Mono.empty(), String.class);
    }

    public Mono<ServerResponse> handlePostFallback(ServerRequest request) {
        return ServerResponse.status(HttpStatus.SERVICE_UNAVAILABLE).build();
    }

    public Mono<ServerResponse> handleGetPostFallback(ServerRequest request) {
        return ServerResponse.ok().body(Mono.just(Author.builder().build()), Author.class);
    }

    public Mono<ServerResponse> handlePostPostFallback(ServerRequest request) {
        return ServerResponse.status(HttpStatus.SERVICE_UNAVAILABLE).build();
    }
}
