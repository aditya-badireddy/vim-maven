package com.cg.vim.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.vim.dao.impl.UserDaoImpl;
import com.cg.vim.model.User;
import com.cg.vim.service.IUserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {
	@Autowired private UserDaoImpl userDaoImpl;
	@Override
	public User fetchUser(String userName) throws Exception {
		try{
			return userDaoImpl.fetchUser(userName);
		} catch(Exception e){
			throw e;
		}
	}
	@Override
	public List<User> findAllUsers() throws Exception {
		try{
			return userDaoImpl.findAll();
		} catch(Exception e){
			throw e;
		}
	}
	@Override
	public User findByUsername(String name) throws Exception{
		try{
			return userDaoImpl.findOne(name);
		} catch(Exception e){
			throw e;
		}
	}
	@Override
	public void saveUser(User user) throws Exception{
		try{
			userDaoImpl.save(user);
		} catch(Exception e){
			throw e;
		}
	}
	@Override
	public void updateUser(User user) throws Exception{
		try{
			saveUser(user);
		} catch(Exception e){
			throw e;
		}
	}
	@Override
	public void deleteUserById(String id) throws Exception{
		try{
			userDaoImpl.delete(id);
		} catch(Exception e){
			throw e;
		}
	}
	@Override
	public void deleteAllUsers() throws Exception{
		try{
			userDaoImpl.deleteAll();
		} catch(Exception e){
			throw e;
		}
	}

	public boolean isExistingUser(User user) throws Exception {
		return findByUsername(user.getUserName()) != null;
	}
}
