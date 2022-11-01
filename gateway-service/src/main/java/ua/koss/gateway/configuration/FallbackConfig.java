package ua.koss.gateway.configuration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class FallbackConfig {

    private final String EMPTY_COLLECTION_REPRESENTATION = Collections.emptyList().toString();

    @GetMapping("/post-fallback")
    private String getMethodPostFallback() {
        return EMPTY_COLLECTION_REPRESENTATION;
    }

    @PostMapping("/post-fallback")
    private String postMethodPostFallback() {
        return "Post service says: woops! Looks like i`m not working";
    }

    @GetMapping("/author-fallback")
    private String getMethodAuthorFallback() {
        return EMPTY_COLLECTION_REPRESENTATION;
    }

    @PostMapping("/author-fallback")
    private String postMethodAuthorFallback() {
        return "Author service says: woops! Looks like i`m not working";
    }
}
