package ua.koss.post.service.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.koss.post.service.dto.PostDto;
import ua.koss.post.service.exception.PostNotFoundException;
import ua.koss.post.service.model.Post;
import ua.koss.post.service.repository.PostRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final AuthorServiceFacade authorServiceFacade;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, AuthorServiceFacade authorServiceFacade) {
        this.postRepository = postRepository;
        this.authorServiceFacade = authorServiceFacade;
    }

    @Override
    public PostDto create(Post post) {
        Post savedPost = createPost(post);
        log.info(String.format("new post was created: %s", savedPost));
        return authorServiceFacade.extendWithAuthorInfo(savedPost);
    }

    private Post createPost(Post post) {
        Post savedPost = null;
        try {
            savedPost = postRepository.save(post);
        } catch (Exception e) {
            log.error(String.format("Create method was crushed due to: %s", e.getMessage()));
        }
        return savedPost;
    }

    @Override
    public PostDto findById(String id) throws PostNotFoundException {
        log.info(String.format("findById method was called with parameter: %s", id));
        Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
        return authorServiceFacade.extendWithAuthorInfo(post);
    }

    @Override
    public List<PostDto> findAll() {
        log.info("findAll method was called");
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(authorServiceFacade::extendWithAuthorInfo).collect(Collectors.toList());
    }

    @Override
    public void deleteById(String id) {
        log.info(String.format("deleteById method was called with parameter: %s", id));
        try {
            postRepository.deleteById(id);
        } catch (IllegalArgumentException e) {
            String message = String.format("no such document exists with id: %s", id);
            log.error(message);
            throw new PostNotFoundException(id);
        }
    }
}
