package com.example.demo.dao;

import com.example.demo.entities.myUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<myUser,Integer> {
    //myUser findUserById(Integer id);

}
