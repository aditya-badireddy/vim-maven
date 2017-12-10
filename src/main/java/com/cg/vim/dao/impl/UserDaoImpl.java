package com.cg.vim.dao.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.vim.model.User;

@Repository
public interface UserDaoImpl extends JpaRepository<User,String>{

	@Transactional
	@Query("select u from User u where u.userName=?1")
	public User fetchUser(String userName);

}