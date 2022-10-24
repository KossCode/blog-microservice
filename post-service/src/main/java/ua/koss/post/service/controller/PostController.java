package ua.koss.post.service.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.koss.post.service.dto.AllPostsDto;
import ua.koss.post.service.dto.PostDto;
import ua.koss.post.service.model.Post;
import ua.koss.post.service.service.PostService;


import javax.validation.Valid;
import java.util.List;

import static ua.koss.post.service.constants.PostLinks.POST_CONTROLLER_LINK;

@Slf4j
@RestController
@RequestMapping(POST_CONTROLLER_LINK)
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<AllPostsDto> getAllPosts() {
        log.info("getAllPosts method was called");
        List<PostDto> allPosts = postService.findAll();
        return ResponseEntity.ok(
                                AllPostsDto.builder()
                                        .quantity(allPosts.size())
                                        .postsDto(allPosts)
                                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable("id") String id) {
        log.info("getPostById method was called");
        return ResponseEntity.ok(postService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody @Valid Post post) {
        log.info(String.format("createPost method was called with document: %s", post));
        PostDto createdPost = postService.create(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
    }
}
