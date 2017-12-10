package com.cg.vim.service;

import com.cg.vim.model.Vehicle;

public interface IVehicleService {

	Vehicle fetchVehicle(String userName) throws Exception;

}
