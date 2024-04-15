package dev.daniel.blog.post.service;

import dev.daniel.blog.post.model.Post;
import dev.daniel.blog.post.repository.PostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public void delete(Long id){
        if(!postRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }
        postRepository.deleteById(id);
    }
}
