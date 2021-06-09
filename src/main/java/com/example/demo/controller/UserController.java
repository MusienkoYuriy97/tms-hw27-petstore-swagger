package com.example.demo.controller;

import com.example.demo.model.Token;
import com.example.demo.model.User;
import com.example.demo.service.TokenService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody User user){
        if (userService.save(user)){
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/login")
    public ResponseEntity<Token> login(String username, String password){
        if (userService.login(username,password)){
            Token token = tokenService.generate(username);
            return new ResponseEntity<>(token, HttpStatus.ACCEPTED);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader("X-Token") String tokenId){
        if (tokenService.remove(tokenId)){
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{username}")
    public void delete(@PathVariable String username){

    }


    @PutMapping("/{username}")
    public void update(@PathVariable String username, @RequestBody User user){

    }

    @GetMapping("/{username}")
    public ResponseEntity<User> get(@PathVariable String username){
        return null;
    }

    @PostMapping("/createWithArray")
    public void createWithArray(@RequestBody User[] user){

    }

    @PostMapping("/createWithList")
    public void createWithList(@RequestBody List<User> user){

    }
}
