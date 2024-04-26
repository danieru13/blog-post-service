package dev.daniel.blog.post.repository;

import dev.daniel.blog.post.model.Post;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends ListCrudRepository<Post, Long> {
    List<Post> findAllByTitleContainsIgnoreCase(String keyword);
}
