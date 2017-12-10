package com.cg.vim.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vim.model.Vehicle;
import com.cg.vim.service.IVehicleService;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {
	@Autowired
	private IVehicleService vehicleService;
	
	
	@RequestMapping(value="/fetchUser/{userName}",method=RequestMethod.GET)
	public Vehicle fetchUser(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("model") String model) throws Exception{
			return vehicleService.fetchVehicle(model);
	}
}
