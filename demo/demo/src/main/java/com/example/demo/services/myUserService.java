package com.example.demo.services;

import com.example.demo.entities.myUser;

import java.util.List;
import java.util.Optional;

public interface myUserService {
    public List<myUser> getAllUsers();
    public Optional<myUser> findUserById(int id);
    public myUser saveUser(myUser newuser);
    public myUser updateUser(myUser newuser);
    public void deleteUser(int id);

}
