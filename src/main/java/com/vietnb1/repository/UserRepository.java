package com.vietnb1.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.vietnb1.entity.User;

@Mapper
public interface UserRepository {

    @Select("SELECT * FROM users")
    public List<User> getAllUser();

    @Insert("INSERT INTO users(id, email, password, username) VALUES (#{id}, #{email} , #{password}, #{username})")
    public void insertUser(User user);

    @Delete("DELETE FROM users WHERE id = #{userId}")
    public void deleteUser(int userId);
}
