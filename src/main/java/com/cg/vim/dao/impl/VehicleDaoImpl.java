package com.cg.vim.dao.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.vim.model.Vehicle;

@Repository
public interface VehicleDaoImpl extends JpaRepository<Vehicle,String>{

	@Transactional
	@Query("select v from Vehicle v where v.model=?1")
	public Vehicle fetchVehicle(String model);

}
