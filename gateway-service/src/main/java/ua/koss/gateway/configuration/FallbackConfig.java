package ua.koss.gateway.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import ua.koss.gateway.model.Author;
import ua.koss.gateway.model.Post;

import java.util.Collections;

//@Configuration
@RestController
public class FallbackConfig {

    private final String EMPTY_COLLECTION_REPRESENTATION = Collections.emptyList().toString();

//    @Bean
//    public RouterFunction<ServerResponse> routerFunction() {
//        return RouterFunctions
//                .route(RequestPredicates.GET("/author-fallback"), this::authorServiceGetFallback)
//                .andRoute(RequestPredicates.POST("/author-fallback"), this::authorServicePostFallback)
//                .andRoute(RequestPredicates.GET("/post-fallback"), this::postServiceGetFallback)
//                .andRoute(RequestPredicates.POST("/post-fallback"), this::postServicePostFallback);
//    }
//
//    public Mono<ServerResponse> authorServiceGetFallback(ServerRequest request) {
//        return ServerResponse.ok().body(Mono.just(Author.builder().build()), Author.class);
//    }
//
//    public Mono<ServerResponse> authorServicePostFallback(ServerRequest request) {
//        return ServerResponse.status(HttpStatus.SERVICE_UNAVAILABLE).body(Mono.empty(), String.class);
//    }
//
//    public Mono<ServerResponse> postServiceGetFallback(ServerRequest request) {
//        return ServerResponse.ok().body(Mono.just(Post.builder().build()), Post.class);
//    }
//
//    public Mono<ServerResponse> postServicePostFallback(ServerRequest request) {
//        return ServerResponse.status(HttpStatus.SERVICE_UNAVAILABLE).build();
//    }

    @GetMapping("/post-fallback")
    private String getMethodPostFallback() {
        return EMPTY_COLLECTION_REPRESENTATION;
    }

    @GetMapping("/post-fallback/{id}")
    private String getMethodPostFallback(@PathVariable("id") String id) {
        return Post.builder().id(id).build().toString();
    }

    @PostMapping("/post-fallback")
    private String postMethodPostFallback() {
        return "post says woops!";
    }

    @GetMapping("/author-fallback/{id}")
    private String getMethodWithIdAuthorFallback(@PathVariable("id") long id) {
        return Author.builder().id(id).build().toString();
    }

    @GetMapping("/author-fallback")
    private String getMethodAuthorFallback() {
        return EMPTY_COLLECTION_REPRESENTATION;
    }

    @PostMapping("/author-fallback")
    private String postMethodAuthorFallback() {
        return "post says woops!";
    }
}
