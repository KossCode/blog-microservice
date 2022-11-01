package ua.koss.gateway.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutesConfig {
    @Value("${AUTHOR_PATH}")
    private String authorServicePath;
    @Value("${AUTHOR_URL}")
    private String authorServiceUrl;
    @Value("${POST_PATH}")
    private String postServicePath;
    @Value("${POST_URL}")
    private String postServiceUrl;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("authorService",p -> p
                        .path(authorServicePath)
                        .filters(f -> f.circuitBreaker(c->c.setName("authorService").setFallbackUri("/author-fallback")))
                        .uri(authorServiceUrl))
                .route("postService",p -> p
                        .path(postServicePath)
                        .filters(f -> f.circuitBreaker(c->c.setName("postService").setFallbackUri("/post-fallback")))
                        .uri(postServiceUrl))
                .build();
    }
}
