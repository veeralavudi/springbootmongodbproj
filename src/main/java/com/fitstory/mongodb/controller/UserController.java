package com.fitstory.mongodb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fitstory.mongodb.entity.User;
import com.fitstory.mongodb.repository.UserRepository;

@RestController
@RequestMapping(value = "/")
public class UserController {
	

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	private final UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public User addNewUsers(@RequestBody User user) {
		LOG.info("Saving user.");
		return userRepository.save(user);
	}
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public User getUser(@PathVariable String userId) {
		LOG.info("Getting user with ID: {}.", userId);
		return userRepository.findById(userId).orElse(null);
	}
		@RequestMapping(value = "/all", method = RequestMethod.GET)
		public List<User> getAllUsers() {
			LOG.info("Getting all users.");
			return userRepository.findAll();   
		}
	
}
