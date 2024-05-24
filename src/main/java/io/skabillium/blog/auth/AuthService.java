package io.skabillium.blog.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.skabillium.blog.users.UsersService;

@Service
public class AuthService {
    private final UsersService usersService;

    @Autowired
    AuthService(UsersService usersService) {
        this.usersService = usersService;
    }

    public void register() {
    }

    public void login() {
    }
}
