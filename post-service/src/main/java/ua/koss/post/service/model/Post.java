package ua.koss.post.service.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@ToString
@Document(collection = "POSTS")
public class Post {
    @Id
    private String id;
    @NotBlank(message = "Post title should be not blank")
    private String title;
    @NotBlank(message = "Post body should be not blank")
    private String body;
    @NotBlank(message = "Post authorId should be set")
    private String authorId;
}
