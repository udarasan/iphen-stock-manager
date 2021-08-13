package com.iphentechnologies.stockmanager.service;

import com.iphentechnologies.stockmanager.dto.UserDTO;

public interface UserService {
    void addUser(UserDTO userDTO);
    boolean passwordMatchesNic(String email, String password);
}
