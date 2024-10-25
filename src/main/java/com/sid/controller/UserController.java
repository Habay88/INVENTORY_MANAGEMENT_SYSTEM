package com.sid.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sid.model.Role;
import com.sid.model.User;
import com.sid.service.UserService;

import java.util.List;
import java.util.Set;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/username/{username}")
    public User getUserByUsername(@PathVariable("username") String username){
        return userService.getUserByUsername(username);
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }


    @PutMapping("/user/{id}")
    public User updateUser(@RequestBody() User user, @PathVariable("id") Long id){
        return userService.updateUser(user, id);
    }

    @PostMapping("/users")
    public ResponseEntity<User> addNew(@RequestBody() User user){
        User newUser = userService.addNew(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
    }

    @PutMapping("/user/{id}/roles")
    public User updateUser(@RequestBody() List<Role> roles, @PathVariable("id") Long id){
        User user = userService.getUserById(id);
        user.setRoles(roles);
        return userService.updateUser(user, id);
    }
}