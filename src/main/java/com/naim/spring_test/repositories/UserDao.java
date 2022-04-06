package com.naim.spring_test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naim.spring_test.model.User;


public interface UserDao extends JpaRepository<User, Long>{

}
