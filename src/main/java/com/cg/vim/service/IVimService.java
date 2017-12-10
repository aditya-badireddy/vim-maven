package com.cg.vim.service;

import java.util.List;

import com.cg.vim.model.UserVehicleAssoc;

public interface IVimService {

	List<UserVehicleAssoc> findAll() throws Exception;

}
