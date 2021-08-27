package com.iphentechnologies.stockmanager.service;

import com.iphentechnologies.stockmanager.dto.UserDTO;
import com.iphentechnologies.stockmanager.dto.UserResponseDTO;

public interface UserService {
    void addUser(UserDTO userDTO);

    UserResponseDTO passwordMatchesEmail(String userEmail, String userPassword);
}
