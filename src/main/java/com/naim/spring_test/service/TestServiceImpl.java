package com.naim.spring_test.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naim.spring_test.model.User;
import com.naim.spring_test.repositories.UserDao;

@Service
public class TestServiceImpl implements TestService {
	@Autowired
	private UserDao userDao;

	@Override
	public List<String> getTestData() {
		// TODO Auto-generated method stub
		return new ArrayList<String>(Arrays.asList("Naim", "Mithun", "Forhad"));
	}

	@Override
	public User registerUser(User s) {
		this.userDao.save(s);
		return s;
	}


}
