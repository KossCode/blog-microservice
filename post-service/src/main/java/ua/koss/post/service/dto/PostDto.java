package ua.koss.post.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PostDto {
    private String id;
    @NotEmpty
    private String title;
    @NotNull
    private String body;
    @NotNull
    private AuthorDto author;
}
