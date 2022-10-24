package ua.koss.post.service.service;

import ua.koss.post.service.dto.PostDto;
import ua.koss.post.service.exception.PostNotFoundException;
import ua.koss.post.service.model.Post;

import java.util.List;

public interface PostService {
    PostDto create(Post post);
    PostDto findById(String id) throws PostNotFoundException;
    List<PostDto> findAll();
    void deleteById(String id);
}
