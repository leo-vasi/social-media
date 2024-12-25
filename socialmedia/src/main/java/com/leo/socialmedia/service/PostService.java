package com.leo.socialmedia.service;

import com.leo.socialmedia.domain.Post;
import com.leo.socialmedia.domain.User;
import com.leo.socialmedia.repository.PostRepository;
import com.leo.socialmedia.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        return repository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Object not found"));
    }





}
