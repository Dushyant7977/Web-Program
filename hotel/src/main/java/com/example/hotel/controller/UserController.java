package com.example.hotel.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotel.model.User;
import com.example.hotel.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping("/adduser")
    public User addUser(@RequestBody User user) {
        
        return userService.addUser(user);
    }

    @GetMapping("/getuser")
    public List<User> getUser() {
        return userService.getUser();
    }
    
    @PutMapping("/edituser/{id}")
    public User editUser(@PathVariable Long id, @RequestBody User user) {
        
        return userService.editUser(id,user);
    }

    @DeleteMapping("/deleteuser/{id}")
    public String deleteUser(@PathVariable Long id)
    {
        return userService.deleteUser(id);
    }
    
}
