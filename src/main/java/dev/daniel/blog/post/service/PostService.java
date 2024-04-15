package dev.daniel.blog.post.service;

import dev.daniel.blog.post.model.Post;
import dev.daniel.blog.post.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) { this.postRepository = postRepository;}

    public List<Post> findAll(){return postRepository.findAll();}

    public Optional<Post> findById(Long id){return postRepository.findById(id);}

    public void save(Post post){
        post.setDateCreated(LocalDateTime.now());
        postRepository.save(post);
    }
}
