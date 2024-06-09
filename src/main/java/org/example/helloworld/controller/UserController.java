package org.example.helloworld.controller;

import org.example.helloworld.dto.LoginCredentials;
import org.example.helloworld.dto.RegisterCredentials;
import org.example.helloworld.dto.Response;
import org.example.helloworld.service.UserService;
import org.example.helloworld.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Response<String> register(@RequestBody RegisterCredentials registerCredentials) {
        if (userService.findByName(registerCredentials.getUsername()) != 0) {
            return Response.error("该用户名已被注册");
        }
        userService.register(registerCredentials);
        return Response.success();
    }

    @PostMapping("/login")
    public Response<String> login(@RequestBody LoginCredentials loginCredentials) {
        int result = userService.login(loginCredentials);
        if (result != 0) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("username", loginCredentials.getUsername());
            String token = JwtUtil.genToken(claims);
            return Response.success(token);
        }
        return Response.error("用户名或密码错误");
    }

    @GetMapping("/test")
    public Response<String> test() {
        return Response.success();
    }
}
