package dev.daniel.blog.post.controller;

import dev.daniel.blog.post.model.Post;
import dev.daniel.blog.post.service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("")
    public List<Post> findAll(){
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public Post findById(@PathVariable Long id) {
        return postService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found"));
    }

    @GetMapping("/filter/{keyword}")
    public List<Post> findByTitle(@PathVariable String keyword){
        return postService.findByTitle(keyword);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@RequestBody @Valid Post post){
        postService.save(post);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody @Valid Post post, @PathVariable Long id){
        postService.update(post, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        postService.delete(id);
    }
}
