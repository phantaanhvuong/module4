package com.example.validateformdangky.service;

import com.example.validateformdangky.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    @Override
    public void save(User user) {
        System.out.println("Lưu user:"+ user.getFirstName());
    }
}
