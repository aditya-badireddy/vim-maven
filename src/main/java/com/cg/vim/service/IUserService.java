package com.cg.vim.service;

import java.util.List;

import com.cg.vim.model.User;

public interface IUserService {

	User fetchUser(String userName) throws Exception;
	
	User findByUsername(String userName) throws Exception;

	List<User> findAllUsers() throws Exception;

	void deleteAllUsers() throws Exception;

	void deleteUserById(String id) throws Exception;

	void updateUser(User user) throws Exception;
	
	void saveUser(User user) throws Exception;

	boolean isExistingUser(User user) throws Exception;

}
