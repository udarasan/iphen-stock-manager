package com.iphentechnologies.stockmanager.service.impl;

import com.iphentechnologies.stockmanager.dto.UserDTO;
import com.iphentechnologies.stockmanager.entity.User;
import com.iphentechnologies.stockmanager.repo.UserRepo;
import com.iphentechnologies.stockmanager.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addUser(UserDTO userDTO) {
        userRepo.save(mapper.map(userDTO, User.class));
    }

    @Override
    public boolean passwordMatchesNic(String email, String password) {
        return userRepo.getPassword(email).contentEquals(password);
    }
}
