package ua.koss.post.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
public class AllPostsDto {
    private int quantity;
    private List<PostDto> postsDto;
}
