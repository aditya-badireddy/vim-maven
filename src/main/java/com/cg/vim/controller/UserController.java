package com.cg.vim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.cg.vim.model.User;
import com.cg.vim.service.IUserService;
import com.cg.vim.util.CustomError;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private IUserService userService;

	// -------------------Retrieve All Users---------------------------------------------
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() throws Exception {
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
			return new ResponseEntity<>(new CustomError("User Name " + userName + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
// -------------------Create a User-------------------------------------------

	@RequestMapping(value = "/addUser/", method = RequestMethod.POST)
	public ResponseEntity<Object> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) throws Exception {

		if (userService.isExistingUser(user)) {
			return new ResponseEntity<>(new CustomError("Unable to create. A User with name " + 
					user.getUserName() + " already exists."),HttpStatus.CONFLICT);
		}
		userService.saveUser(user);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/users/{userName}").buildAndExpand(user.getUserName()).toUri());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	/*	
	// ------------------- Update a User ------------------------------------------------

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody User user) {
		logger.info("Updating User with id {}", id);

		User currentUser = userService.findById(id);

		if (currentUser == null) {
			logger.error("Unable to update. User with id {} not found.", id);
			return new ResponseEntity(new CustomError("Unable to upate. User with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentUser.setName(user.getName());
		currentUser.setAge(user.getAge());
		currentUser.setSalary(user.getSalary());

		userService.updateUser(currentUser);
		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	}

	// ------------------- Delete a User-----------------------------------------

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting User with id {}", id);

		User user = userService.findById(id);
		if (user == null) {
			logger.error("Unable to delete. User with id {} not found.", id);
			return new ResponseEntity(new CustomError("Unable to delete. User with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		userService.deleteUserById(id);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All Users-----------------------------

	@RequestMapping(value = "/user/", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteAllUsers() {
		logger.info("Deleting All Users");

		userService.deleteAllUsers();
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}*/

}
