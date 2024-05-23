package io.skabillium.blog.posts;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/posts")
public class PostsController {
    @GetMapping
    public List<Post> getPosts() {
        return List.of(
                new Post("My first post", "body of first post"),
                new Post("My second post", "body of second post"));
    }
}
