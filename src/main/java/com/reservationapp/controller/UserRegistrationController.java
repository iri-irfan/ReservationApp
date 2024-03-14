package com.reservationapp.controller;


import com.reservationapp.entity.UserRegistration;

import com.reservationapp.payload.UserRegistrationDto;
import com.reservationapp.service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserRegistrationController {

    @Autowired
    private UserServiceImpl userService;


    @PostMapping
    public String createUser(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("profilePicture") MultipartFile profilePicture) {
        try {
            UserRegistration userRegistration = new UserRegistration();
            userRegistration.setName(name);
            userRegistration.setEmail(email);
            userRegistration.setPassword(password);
            userRegistration.setProfilePicture(profilePicture.getBytes());
            userService.createUser(userRegistration); // give the user registration object details to service layer

        } catch (Exception e) {
            e.printStackTrace();

        }
        return "User Registered";
    }


    @GetMapping("{id}")
    public ResponseEntity<UserRegistration> getUserById(@PathVariable long id) {
        UserRegistration byId = userService.getUserById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable long id) {
        userService.deletUser(id);
        return new ResponseEntity<>("User is deleted with id:" + id, HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<List<UserRegistrationDto>> getAllUsers() {
        List<UserRegistrationDto> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<UserRegistrationDto> updateUser(@RequestBody UserRegistrationDto userRegistrationDto, @PathVariable long id) {
        UserRegistrationDto registrationDto = userService.updateUser(userRegistrationDto, id);
        return new ResponseEntity<>(registrationDto, HttpStatus.OK);
    }

}