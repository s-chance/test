package org.example.helloworld.service.impl;

import org.example.helloworld.dto.LoginCredentials;
import org.example.helloworld.dto.RegisterCredentials;
import org.example.helloworld.po.User;
import org.example.helloworld.repo.UserRepo;
import org.example.helloworld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public int findByName(String username) {
        return userRepo.findByName(username);
    }

    @Transactional
    @Override
    public void register(RegisterCredentials registerCredentials) {
        userRepo.register(registerCredentials.getUsername(),
                registerCredentials.getPassword());
    }

    @Override
    public int login(LoginCredentials loginCredentials) {
        return userRepo.login(loginCredentials.getUsername(), loginCredentials.getPassword());
    }
}
