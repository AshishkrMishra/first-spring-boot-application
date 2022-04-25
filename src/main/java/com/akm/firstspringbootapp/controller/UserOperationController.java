package com.akm.firstspringbootapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akm.firstspringbootapp.exception.UserNotFoundException;
import com.akm.firstspringbootapp.model.User;
import com.akm.firstspringbootapp.model.UserKey;
import com.akm.firstspringbootapp.repository.UserRepository;

@RestController
@RequestMapping("/firstspringbootapp/api/v1/users")
public class UserOperationController {

	@Autowired
	private UserRepository userRepository;

	// get all user api

	@GetMapping
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	// get user by id

	@GetMapping("/{id}")
	public User getUserById(@PathVariable(value = "id") Long userId) {
		UserKey userkey = new UserKey();
		userkey.setId(userId);
		return userRepository.findById(userkey)
				.orElseThrow(() -> new UserNotFoundException("User not found for Id :" + userId));

	}

	// create user rest api
	@PostMapping("/create")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}

	// update user rest api
	@PostMapping("/update/{id}")
	public User updateUser(@RequestBody User user, @PathVariable(value = "id") Long userId) {
		UserKey userkey = new UserKey();
		userkey.setId(userId);
		User existingUser = userRepository.findById(userkey)
				.orElseThrow(() -> new UserNotFoundException("User not found for Id :" + userId));
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setMiddelName(user.getMiddelName());
		return userRepository.save(existingUser);
	}

	// delete user by id

	// update user rest api
	@PostMapping("/delete/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId) {
		UserKey userkey = new UserKey();
		userkey.setId(userId);
		User existingUser = userRepository.findById(userkey)
				.orElseThrow(() -> new UserNotFoundException("User not found for Id :" + userId));
		userRepository.delete(existingUser);
		return ResponseEntity.ok().build();
	}

}
