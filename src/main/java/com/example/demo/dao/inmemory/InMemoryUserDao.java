package com.example.demo.dao.inmemory;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class InMemoryUserDao implements UserDao {
    private List<User> userList = new ArrayList<>();

    @Override
    public void save(User user) {
        userList.add(user);
    }

    @Override
    public void delete(User user) {
        userList.remove(user);
    }

    @Override
    public Optional<User> getById(int id) {
        for (User user : userList) {
            if (user.getId() == id){
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> getByUsername(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)){
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    @Override
    public void update(String username, User user) {
        for (User u : userList) {
            if (u.getUsername().equals(username)){
                u = user;
            }
        }
    }

    @Override
    public boolean containsById(int id) {
        return userList.stream()
                .anyMatch(user -> user.getId() == id);
    }

    @Override
    public boolean containsByUsername(String username) {
        return userList.stream()
                .anyMatch(user -> user.getUsername().equals(username));
    }

    @Override
    public boolean checkLogin(String username, String password) {
        return userList.stream()
                .filter(user -> user.getUsername().equals(username))
                .anyMatch(user -> user.getPassword().equals(password));
    }
}
