package com.cg.vim.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.vim.dao.impl.VehicleDaoImpl;
import com.cg.vim.model.Vehicle;
import com.cg.vim.service.IVehicleService;

@Service("vehicleService")
@Transactional
public class VehicleServiceImpl implements IVehicleService {
	@Autowired private VehicleDaoImpl vehicleDaoImpl;
	@Override
	public Vehicle fetchVehicle(String model) throws Exception {
		try{
			return vehicleDaoImpl.fetchVehicle(model);
		} catch(Exception e){
			throw e;
		}
	}
}
