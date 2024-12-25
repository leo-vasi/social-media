package com.leo.socialmedia.service;

import com.leo.socialmedia.domain.User;
import com.leo.socialmedia.dto.UserDTO;
import com.leo.socialmedia.repository.UserRepository;
import com.leo.socialmedia.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public User insert(User obj) {
        return repository.insert(obj);
    }

    public User fromDTO(UserDTO objDTO) {
        return new User(objDTO.getEmail(), objDTO.getId(), objDTO.getName());
    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }

    public User update(User obj) {
        Optional<User> optionalUser = repository.findById(obj.getId());
        User newObj = optionalUser.get();
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

}
