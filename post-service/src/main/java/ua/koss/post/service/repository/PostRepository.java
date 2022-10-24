package ua.koss.post.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.koss.post.service.model.Post;

@Repository
public interface PostRepository  extends MongoRepository<Post, String> {
}
