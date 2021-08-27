package com.iphentechnologies.stockmanager.controller;

import com.iphentechnologies.stockmanager.dto.UserDTO;
import com.iphentechnologies.stockmanager.dto.UserResponseDTO;
import com.iphentechnologies.stockmanager.service.UserService;
import com.iphentechnologies.stockmanager.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/user")
@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "/registerUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveUser(@RequestBody UserDTO userDTO) {
        userService.addUser(userDTO);
        return new ResponseEntity(new StandardResponse("201", "Done", userDTO), HttpStatus.CREATED);
    }
    @GetMapping(path = "/login")
    public ResponseEntity loginUser(@RequestParam String userEmail, @RequestParam String userPassword){

        UserResponseDTO userResponseDTO = userService.passwordMatchesEmail(userEmail, userPassword);
        return new ResponseEntity(new StandardResponse("202", "Done", userResponseDTO), HttpStatus.ACCEPTED);

    }
}
