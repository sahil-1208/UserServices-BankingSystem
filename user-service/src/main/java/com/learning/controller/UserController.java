package com.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.enums.Status;
import com.learning.model.UserRequest;
import com.learning.model.UserResponse;
import com.learning.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public UserResponse createNewUser(@RequestBody UserRequest userRequest) {
		return userService.create(userRequest);
	}

	@GetMapping("/{id}")
	public UserResponse getExistingUserById(@PathVariable Long id) {
		return userService.findUserById(id);
	}
	
	@PutMapping("/{id}")
	public UserResponse updateExistingUserById(@PathVariable Long id, @RequestBody UserRequest userRequest) {
		return userService.update(id, userRequest);
	}
	
	@DeleteMapping("/{id}")
	public Status deleteExistingUserById(@PathVariable Long id) {
		return userService.deleteUserById(id);	
	}

}
