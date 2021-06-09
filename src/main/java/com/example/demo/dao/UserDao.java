package com.example.demo.dao;

import com.example.demo.model.User;

import java.util.Optional;

public interface UserDao {
    void save(User user);
    void delete(User user);
    Optional<User> getById(int id);
    Optional<User> getByUsername(String username);
    boolean containsById(int id);
    boolean containsByUsername(String username);
    boolean checkLogin(String username, String password);
}
