package com.example.demo.services;

import com.example.demo.entities.myUser;

import java.util.List;

public interface myUserService {
    public List<myUser> getAllUsers();
    public myUser findUserById(int id);
    public myUser saveUser(myUser newuser);
    public myUser updateUser(myUser newuser);
    public void deleteUser(int id);

}
