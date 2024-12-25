package com.leo.socialmedia.service;

import com.leo.socialmedia.domain.User;
import com.leo.socialmedia.repository.UserRepository;
import com.leo.socialmedia.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        return repository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Object not found"));
    }
}
