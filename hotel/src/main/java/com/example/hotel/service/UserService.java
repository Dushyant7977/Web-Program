package com.example.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel.model.User;
import com.example.hotel.repo.UserRepo;

@Service
public class UserService {
    @Autowired 
    UserRepo userRepo;

    @SuppressWarnings("null")
    public User addUser(User user)
    {
        return userRepo.save(user);
    }

    public List<User> getUser()
    {
        return userRepo.findAll();
    }

    public User editUser(Long id,User user)
    {
        @SuppressWarnings("null")
        User userAvail=userRepo.findById(id).orElse(null);
        if(userAvail!=null)
        {
             userAvail.setName(user.getName());
             userAvail.setRate(user.getRate());
             return userRepo.saveAndFlush(userAvail);
        }
        else
        return null;
    }
    @SuppressWarnings("null")
    public String deleteUser(Long id)
    {
        userRepo.deleteById(id);
        return ("user deleted");
        
    }
}
