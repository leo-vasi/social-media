package com.leo.socialmedia.config;

import com.leo.socialmedia.domain.User;
import com.leo.socialmedia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();

        User maria = new User("maria@gmail.com", null,  "Maria Brown");
        User alex = new User("alex@gmail.com", null, "Alex Green");
        User bob = new User("bob@gmail.com",null, "Bob Grey");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
    }
}
