package com.vietnb1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vietnb1.configuration.DataSourceContextHolder;
import com.vietnb1.configuration.DataSourceType;
import com.vietnb1.entity.User;
import com.vietnb1.repository.UserRepository;
import com.vietnb1.services.UserService;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUser() {
        DataSourceContextHolder.setDatasourceType(DataSourceType.N);
        return userRepository.getAllUser();
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> createTutorial(@RequestBody User user) {
        try {
            DataSourceContextHolder.setDatasourceType(DataSourceType.N);
            userService.inserUser(user);
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
