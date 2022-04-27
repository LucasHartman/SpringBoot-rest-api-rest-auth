package com.lib.springbootrestapirestauth.controller;

import com.lib.springbootrestapirestauth.entity.UserCreateRequest;
import com.lib.springbootrestapirestauth.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

/*
--  This Class
-   Creates new users using user service
 */

@RestController
@RequestMapping(value = "/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity createUser (@RequestBody UserCreateRequest userCreateRequest) {
        userService.createUser(userCreateRequest);
        return ResponseEntity.ok().build();
    }

}