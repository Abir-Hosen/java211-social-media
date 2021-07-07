package com.abir.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abir.project.modal.User;
import com.abir.project.service.UserService;


@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	User createShortainer(@RequestBody User user) {
		System.out.println("create user");
		return userService.save(user);
	}
	
	@GetMapping("/{id}")
	User findUser(@PathVariable  Long id) {
		return userService.findById(id);
	}

}
