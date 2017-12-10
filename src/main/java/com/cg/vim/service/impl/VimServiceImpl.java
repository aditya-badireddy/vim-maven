package com.cg.vim.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.vim.dao.impl.VimDao;
import com.cg.vim.model.UserVehicleAssoc;
import com.cg.vim.service.IVimService;

@Service("vimService")
@Transactional
public class VimServiceImpl implements IVimService{
	@Autowired private VimDao vimDaoImpl;
	@Override
	public List<UserVehicleAssoc> findAll() throws Exception {
		return vimDaoImpl.findAll();
	}

}
