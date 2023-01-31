package com.remote.hospital.controller;

import com.remote.hospital.entity.User;
import com.remote.hospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UserController {


    @Autowired
    private UserService userService;


    @GetMapping("/user")
    public List<User>  getAllUsers(){



        return userService.findAllUser();

    }
    @PostMapping("/user")
    public User saveUser(@RequestBody User user){


       return userService.saveUser(user);

    }

    @PostMapping("/login")
    public User Login(@RequestBody User user) {

        return userService.Login(user.getEmailAddress(), user.getPassword());
    }


    @GetMapping("/doctors")
    public  List<User> getDoctors(){
        return userService.getDoctors();

    }

}



