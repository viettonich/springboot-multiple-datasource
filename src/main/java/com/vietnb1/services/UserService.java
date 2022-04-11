package com.vietnb1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vietnb1.entity.User;
import com.vietnb1.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void inserUser(User user) {
        userRepository.insertUser(user);
    }

}
