package com.naim.spring_test.service;

import java.util.List;

import com.naim.spring_test.model.User;



public interface TestService {
  public List<String> getTestData();
  public User registerUser(User user);
}
