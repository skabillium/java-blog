package io.skabillium.blog.posts;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.skabillium.blog.posts.dto.CreatePostDto;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping(path = "api/v1/posts")
public class PostsController {
    private final PostsService postsService;

    @Autowired
    PostsController(PostsService postsService) {
        this.postsService = postsService;
    }

    @GetMapping
    public List<Post> getPosts() {
        return postsService.getPosts();
    }

    @PostMapping
    public ResponseEntity<String> createPost(@Valid @RequestBody CreatePostDto createPostDto,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            var errors = new StringBuilder();
            bindingResult.getAllErrors().forEach(error -> errors.append(error.getDefaultMessage()).append(", "));
            return new ResponseEntity<String>(errors.toString(), HttpStatus.BAD_REQUEST);
        }
        postsService.createPost(createPostDto);
        return new ResponseEntity<String>("", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable("id") String id) {
        var uuid = UUID.fromString(id);
        postsService.removePost(uuid);
    }
}
