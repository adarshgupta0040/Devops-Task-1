package com.nagarro.librest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.librest.entities.Users;

public interface UserRepo extends JpaRepository<Users,String>{

}