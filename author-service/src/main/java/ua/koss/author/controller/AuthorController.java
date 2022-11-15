package ua.koss.author.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.koss.author.entity.Author;
import ua.koss.author.model.AllAuthorsDto;
import ua.koss.author.model.AuthorDto;
import ua.koss.author.service.AuthorService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(
        value = "/authors",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthorController {

    private final AuthorService authorService;

    @Value("${control-message}")
    private static String message;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> getAuthorInformation(@PathVariable("id") long id) {
        log.info(String.format("AuthorController: getAuthorInformation(), parameters: %s", id));
        AuthorDto author = authorService.findById(id);
        return ResponseEntity.ok(author);
    }

    @GetMapping
    public ResponseEntity<AllAuthorsDto> getAllAuthors() {
        log.info(message);
        log.info("AuthorController: getAllAuthors()");
        List<AuthorDto> allAuthors = authorService.findAll();
        AllAuthorsDto authorsResponseObject = AllAuthorsDto
                .builder()
                .quantity(allAuthors.size())
                .authorsList(allAuthors)
                .build();
        return ResponseEntity.ok(authorsResponseObject);
    }

    @PostMapping
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody Author author) {
        log.info(String.format("AuthorController: createAuthor(), parameter: %s", author));
        AuthorDto orUpdateAuthor = authorService.createOrUpdateAuthor(author);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(orUpdateAuthor);
    }
}
