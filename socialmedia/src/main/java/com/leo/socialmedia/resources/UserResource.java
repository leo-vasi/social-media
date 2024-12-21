package com.leo.socialmedia.resources;

import com.leo.socialmedia.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User maria = new User("maria@gmail.com", "1", "Maria");
        User alex = new User("alex@gmail.com", "2", "Alex");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria,alex));
        return ResponseEntity.ok().body(list);
    }
}
