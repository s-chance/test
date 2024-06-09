package org.example.helloworld.service;

import org.example.helloworld.dto.LoginCredentials;
import org.example.helloworld.dto.RegisterCredentials;
import org.example.helloworld.po.User;

import java.util.Optional;

public interface UserService {
    int findByName(String username);

    void register(RegisterCredentials registerCredentials);

    int login(LoginCredentials loginCredentials);
}
