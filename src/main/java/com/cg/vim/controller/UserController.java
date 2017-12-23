package com.cg.vim.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.cg.vim.model.User;
import com.cg.vim.service.IUserService;
import com.cg.vim.util.CustomError;
import com.cg.vim.util.ObjectMapper;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private IUserService userService;

	ObjectMapper mapper = new ObjectMapper();
	static final Logger LOGGER = LogManager.getLogger(UserController.class);
	// -------------------Retrieve All Users---------------------------------------------
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() throws Exception {
		LOGGER.info("UserController.listAllUsers() called.");
		List<User> users = userService.findAllUsers();
		if (users.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	// -------------------Retrieve Single User------------------------------------------
	@RequestMapping(value = "/{userName}", method = RequestMethod.GET)
	public ResponseEntity<Object> getUser(@PathVariable("userName") String userName) throws Exception {
		User user = userService.fetchUser(userName);
		if (user == null) {
			return new ResponseEntity<>(new CustomError("User '" + userName + "' not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	// -------------------Create a User-------------------------------------------
	@RequestMapping(value = "/addUser/", method = RequestMethod.POST)
	public ResponseEntity<Object> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) throws Exception {

		if (userService.isExistingUser(user)) {
			return new ResponseEntity<>(new CustomError("Unable to create. A User '" + 
					user.getUserName() + "' already exists."),HttpStatus.CONFLICT);
		}
		userService.saveUser(user);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/users/{userName}").buildAndExpand(user.getUserName()).toUri());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	// ------------------- Update a User ------------------------------------------------
	@RequestMapping(value = "/updateUser/{userName}", method = RequestMethod.POST)
	public ResponseEntity<Object> updateUser(@PathVariable("userName") String userName, @RequestBody User user) throws Exception {

		User currentUser = userService.findByUsername(userName);
		if (currentUser == null) {
			return new ResponseEntity<>(new CustomError("Unable to upate. User '" + userName + "' not found."),
					HttpStatus.NOT_FOUND);
		}
		mapper.mapUser(user, currentUser);
		userService.updateUser(currentUser);
		return new ResponseEntity<>(currentUser, HttpStatus.OK);
	}
	// ------------------- Delete a User-----------------------------------------
	@RequestMapping(value = "/deleteUser/{userName}", method = RequestMethod.POST)
	public ResponseEntity<Object> deleteUser(@PathVariable("userName") String userName) throws Exception {

		User user = userService.findByUsername(userName);
		if (user == null) {
			return new ResponseEntity<>(new CustomError("Unable to delete. User '" + userName + "' not found."),
					HttpStatus.NOT_FOUND);
		}
		userService.deleteUserById(userName);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
