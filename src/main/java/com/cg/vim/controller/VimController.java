package com.cg.vim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vim.model.UserVehicleAssoc;
import com.cg.vim.service.IVimService;

@RestController
@RequestMapping("/api/vim")
public class VimController {
	@Autowired
	private IVimService vimService;

	// -------------------Retrieve All Users---------------------------------------------
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<UserVehicleAssoc>> listVim() throws Exception {
		List<UserVehicleAssoc> inventory = vimService.findAll();
		if (inventory.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(inventory, HttpStatus.OK);
	}
}
