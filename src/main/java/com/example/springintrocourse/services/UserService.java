package com.example.springintrocourse.services;

import com.example.springintrocourse.domain.User;
import com.example.springintrocourse.repositories.UserRepository;
import com.example.springintrocourse.services.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    public User findById(Integer id){
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found!"));
    }
}
