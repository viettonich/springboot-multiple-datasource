package com.vietnb1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vietnb1.configuration.DataSourceContextHolder;
import com.vietnb1.configuration.DataSourceType;
import com.vietnb1.entity.User;
import com.vietnb1.repository.UserRepository;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUser() {
        DataSourceContextHolder.setDatasourceType(DataSourceType.N);
        return userRepository.getAllUser();
    }
}
