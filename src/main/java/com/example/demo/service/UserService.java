package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserService {
    @Autowired
    private UserDao userDao;

    public boolean save(User user){
        if (checkSave(user.getId(),user.getUsername())){
            userDao.save(user);
            return true;
        }
        return false;
    }

    public boolean login(String username, String password){
        if (userDao.checkLogin(username, password)){
            return true;
        }
        return false;
    }

    public User getByUsername(String username){
        Optional<User> byId = userDao.getByUsername(username);
        if (byId.isPresent()) {
            return byId.get();
        }
        return null;
    }


    private boolean checkSave(int id, String username){
        if (userDao.containsById(id)){
            return false;
        }
        return !userDao.containsByUsername(username);
    }

}
