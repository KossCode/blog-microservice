package ua.koss.author.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ua.koss.author.entity.Author;
import ua.koss.author.entity.User;
import ua.koss.author.repository.AuthorRepository;
import ua.koss.author.repository.UserRepository;

import java.util.List;

@Component
public class ApplicationRunnerImpl implements ApplicationRunner {
    private final UserRepository userRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public ApplicationRunnerImpl(UserRepository userRepository, AuthorRepository authorRepository) {
        this.userRepository = userRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User admin = User.builder().username("admin").password("admin").build();
        User user = User.builder().username("user").password("user").build();

        Author author1 = new Author();
        author1.setFirstName("Mike");
        author1.setSecondName("Tyson");

        Author author2 = new Author();
        author2.setFirstName("Lenny");
        author2.setSecondName("Borinson");

        Iterable<User> users = userRepository.saveAll(List.of(admin, user));
        Iterable<Author> authors = authorRepository.saveAll(List.of(author1, author2));

        System.out.println(users);
        System.out.println(authors);
    }
}
