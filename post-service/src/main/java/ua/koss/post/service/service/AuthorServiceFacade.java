package ua.koss.post.service.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.koss.post.service.dto.AuthorDto;
import ua.koss.post.service.dto.PostDto;
import ua.koss.post.service.mapper.PostMapper;
import ua.koss.post.service.model.Post;

@Service
@Slf4j
public class AuthorServiceFacade {
    private final AuthorServiceWebImpl authorServiceWeb;

    @Autowired
    public AuthorServiceFacade(AuthorServiceWebImpl authorServiceWeb) {
        this.authorServiceWeb = authorServiceWeb;
    }

    public PostDto extendWithAuthorInfo(Post post) {
        AuthorDto authorDto = fetchAuthorById(post.getAuthorId());
        PostDto postDto = PostMapper.INSTANCE.postToPostDto(post);
        postDto.setAuthor(authorDto);
        return postDto;
    }

    private AuthorDto fetchAuthorById(String id) {
       return authorServiceWeb.findAuthorById(id);
    }
}
