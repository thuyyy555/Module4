package com.example.ss8.service;

import com.example.ss8.model.User;
import com.example.ss8.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository repository;
    @Override
    public boolean create(User user) {
        repository.save(user);
        return true;
    }
}
