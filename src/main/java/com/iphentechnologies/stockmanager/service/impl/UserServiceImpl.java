package com.iphentechnologies.stockmanager.service.impl;

import com.iphentechnologies.stockmanager.dto.UserDTO;
import com.iphentechnologies.stockmanager.dto.UserResponseDTO;
import com.iphentechnologies.stockmanager.entity.User;
import com.iphentechnologies.stockmanager.exception.ValidateException;
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
        if (userRepo.existsByUserEmail(userDTO.getUserEmail())) {
            throw new ValidateException("This Email Has Already User Account!");
        }
        userRepo.save(mapper.map(userDTO, User.class));
    }

    @Override
    public UserResponseDTO passwordMatchesEmail(String userEmail, String userPassword) {
        System.out.println(userEmail+""+userPassword);
        if (userRepo.existsByUserEmail(userEmail)) {
            User all = userRepo.getUser(userEmail);
            if (all.getUserPassword().equals(userPassword)) {
                return mapper.map(all, UserResponseDTO.class);
            } else {
                throw new ValidateException("Password And Email Missed Matched!");
            }
        }
        throw new ValidateException("No Account For This Email!");

    }
}
