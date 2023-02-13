package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.services.myUserService;
import com.example.demo.entities.myUser;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class TestController {
    @Autowired
    private myUserService myuserservice;

//    @GetMapping(value = "/test")
//    public String firstFuction()
//    {
//        return "hello world";
//    }

    @PostMapping("/saveUser")
    public myUser saveUser(@RequestBody myUser newuser)
    {
        return this.myuserservice.saveUser(newuser);
    }

    @GetMapping("/getAllUsers")
    public Iterable<myUser> getAllUsers()
    {
        return this.myuserservice.getAllUsers();

    }

    @GetMapping("/find/{id}")
    public Optional<myUser> findUserById(@PathVariable Integer id) {

        return this.myuserservice.findUserById(id);
    }
    @PutMapping("/edituser")
    public myUser updateUser(@RequestBody myUser newuser)
    {
        return this.myuserservice.updateUser(newuser);
    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Integer id)
    {
        try {
            this.myuserservice.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }




}
