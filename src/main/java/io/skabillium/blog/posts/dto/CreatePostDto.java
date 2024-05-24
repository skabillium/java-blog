package io.skabillium.blog.posts.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreatePostDto {
    @NotBlank(message = "title must not be empty")
    @Size(min = 1, max = 100)
    private String title;
    private String body;
}
