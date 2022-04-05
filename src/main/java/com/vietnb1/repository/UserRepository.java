package com.vietnb1.repository;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.vietnb1.entity.User;

public interface UserRepository {
    
    @Select("SELECT * FROM users")
    public List<User> getAllUser();
}
