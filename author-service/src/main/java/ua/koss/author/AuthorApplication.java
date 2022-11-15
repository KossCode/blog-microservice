package ua.koss.author;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
@EnableJpaRepositories(basePackages = "ua.koss.author.repository")
@Slf4j
public class AuthorApplication {

    @Value("${control-message}")
    private static String message;

    public static void main(String[] args) {
        log.info(message);
        SpringApplication.run(AuthorApplication.class, args);
    }
}
