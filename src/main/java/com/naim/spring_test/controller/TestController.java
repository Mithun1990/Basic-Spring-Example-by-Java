package com.naim.spring_test.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.naim.spring_test.model.User;
import com.naim.spring_test.service.TestService;

@Controller
public class TestController {
	@Autowired
	public TestService testService;

	@GetMapping("/test")
	@ResponseBody
	public List<String> testGet() {
		return this.testService.getTestData();
	}

//	@PostMapping("/userinfo")
//	public ResponseEntity<HttpStatus> registerUser(@RequestBody User user){
//		testService.registerUser(user);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}

	@PostMapping("/userinfo")
	public ResponseEntity<HttpStatus> registerUser(@RequestParam(name = "name", required = true) String name,
			@RequestParam(name="email", required = true) String email, 
			@RequestParam(name="mobileNo", required = true) String phone) {
	
		testService.registerUser(new User(name, email, phone));
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
