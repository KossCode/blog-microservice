package ua.koss.author.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ua.koss.author.entity.Author;
import ua.koss.author.entity.User;
import ua.koss.author.repository.UserRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ApplicationRunnerImpl implements ApplicationRunner {
    private final UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Author author1 = new Author();
        author1.setFirstName("Mike");
        author1.setSecondName("Tyson");

        Author author2 = new Author();
        author2.setFirstName("Lenny");
        author2.setSecondName("Borinson");

        User admin = User.builder().login("admin").password("YWRtaW4=").author(author1).build();
        User user = User.builder().login("user").password("dXNlcg==").author(author2).build();

        Iterable<User> users = userRepository.saveAll(List.of(admin, user));

        System.out.println(users);
    }
}
