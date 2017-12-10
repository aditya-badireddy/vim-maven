package com.cg.vim.dao.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.vim.model.UserVehicleAssoc;

@Repository
public interface VimDao extends JpaRepository<UserVehicleAssoc,String>{

}
