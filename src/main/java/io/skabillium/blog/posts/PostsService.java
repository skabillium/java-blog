package io.skabillium.blog.posts;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.skabillium.blog.posts.dto.CreatePostDto;

@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Autowired
    public PostsService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    public List<Post> getPosts() {
        return postsRepository.findAll();
    }

    public void createPost(CreatePostDto createPostDto) {
        postsRepository.save(new Post(createPostDto.getTitle(), createPostDto.getBody()));
    }

    public void removePost(UUID id) {
        postsRepository.deleteById(id);
    }
}
