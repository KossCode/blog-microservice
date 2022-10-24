package ua.koss.post.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class HttpClient {
    @Value("${gateway.service.url}")
    private String webServiceUrl;

    @Bean
    @LoadBalanced
    public WebClient.Builder webClient() {
        return WebClient.builder()
                .baseUrl(webServiceUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
    }
}
