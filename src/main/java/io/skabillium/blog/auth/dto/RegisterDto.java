package io.skabillium.blog.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterDto {
    @Email
    private String email;
    @NotEmpty
    @Size(min = 8)
    private String password;
}
