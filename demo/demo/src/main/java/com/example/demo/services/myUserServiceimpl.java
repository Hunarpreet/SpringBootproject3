package com.example.demo.services;

import com.example.demo.dao.UserRepository;
import com.example.demo.entities.myUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class myUserServiceimpl implements myUserService {
    @Autowired
    public UserRepository userRepository;

    @Override
    public List<myUser> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<myUser> findUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public myUser saveUser(myUser newuser) {
        userRepository.save(newuser);
        return newuser;
    }

    @Override
    public myUser updateUser(myUser newuser) {
        userRepository.save(newuser);
        return newuser;
    }

    @Override
    public void deleteUser(int id) {
        myUser tempEntity= userRepository.getOne(id);
        userRepository.delete(tempEntity);

    }


}
