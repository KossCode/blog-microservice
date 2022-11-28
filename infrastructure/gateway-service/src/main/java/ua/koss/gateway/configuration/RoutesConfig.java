package ua.koss.gateway.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.koss.gateway.domain.ApiKey;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static ua.koss.gateway.configuration.AppConstant.AUTHOR_SERVICE_KEY;
import static ua.koss.gateway.configuration.AppConstant.POST_SERVICE_KEY;

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
    @Autowired
    private RedisHashComponent redisHashComponent;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(AUTHOR_SERVICE_KEY, p -> p
                        .path(authorServicePath)
                        .filters(f -> f.circuitBreaker(c->c.setName(AUTHOR_SERVICE_KEY)))
                        .uri(authorServiceUrl))
                .route(POST_SERVICE_KEY, p -> p
                        .path(postServicePath)
                        .filters(f -> f.circuitBreaker(c->c.setName(POST_SERVICE_KEY)))
                        .uri(postServiceUrl))
                .build();
    }

    @PostConstruct
    public void initData() {
        List<ApiKey> apiKeys = new ArrayList<>();
        apiKeys.add(new ApiKey("343C-ED0B-4137-B27E", List.of(POST_SERVICE_KEY, AUTHOR_SERVICE_KEY)));
        apiKeys.add(new ApiKey("FA48-EF0C-427E-8CCF", List.of(POST_SERVICE_KEY)));

        List<Object> list = redisHashComponent.hVals(AppConstant.RECORD_KEY);
        if(list.isEmpty()){
            apiKeys.forEach(k -> redisHashComponent.hSet(AppConstant.RECORD_KEY,k.getKey() , k));
        }
    }

}
