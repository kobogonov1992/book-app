package com.example.bookapp.service.impl;

import com.example.bookapp.model.User;
import com.example.bookapp.model.dto.UserDto;
import com.example.bookapp.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserServiceImpl {

    private final UserRepo userRepo;
    private final BCryptPasswordEncoder passwordEncoder;


    public void createUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepo.save(user);
    }

}