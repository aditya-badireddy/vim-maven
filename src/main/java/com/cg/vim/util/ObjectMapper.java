package com.cg.vim.util;

import com.cg.vim.model.User;

public class ObjectMapper {
public User mapUser(User dto, User entity) {
	entity.setDob(dto.getDob());
	entity.setEmail(dto.getEmail());
	entity.setFirstName(dto.getFirstName());
	entity.setGender(dto.getGender());
	entity.setLastName(dto.getLastName());
	entity.setMobile(dto.getMobile());
	entity.setUserVehicleAssocs(dto.getUserVehicleAssocs());
	return entity;
}
}
