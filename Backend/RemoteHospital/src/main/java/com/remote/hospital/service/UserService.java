package com.remote.hospital.service;

import com.remote.hospital.entity.Role;
import com.remote.hospital.entity.User;
import com.remote.hospital.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

//    public void saveUser(User user) {
//        userRepository.save(user);
//    }

    //login method start
    public User Login(String email, String password) {
        User user = userRepository.findByEmailAddress(email);

        return  user;

    }


    public User getUserByEmail(String email) {
        return userRepository.findByEmailAddress(email);
    }

    @CrossOrigin
    public List<User> getDoctors() {

        return userRepository.findAll();
//
//        List<User> allUsers = userRepository.findAll().stream().filter(k->k.getRole() != null)
//                .collect(Collectors.toList());
//        List<User> inActiveDoctors = null;
//
//           List<User> Doctors = allUsers.stream().filter(k -> k.getRole().getId() == 3)
//                    .collect(Collectors.toList());

//        return  userRepository.findAll().stream().filter(u-> u.getActive() !=null && u.getActive() == false && u.getRole().getId() == 3).collect(Collectors.toList());

    }

    public User saveUser(User user) {
        user.setCreated_on(new Date());
        if (user.getRole()
                .getId() == 2){
            user.setActive(false);
        }
        else {
            user.setActive(true);
        }
        return userRepository.save(user);
    }

    //login method end



//    public User findByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }
//
//    public User findByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }
//
//    public User findByPhoneNumber(String phoneNumber) {
//        return userRepository.findByPhoneNumber(phoneNumber);
//    }
//
//    public User findByUsernameOrEmail(String username, String email) {
//        return userRepository.findByUsernameOrEmail(username, email);
//    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }








}
