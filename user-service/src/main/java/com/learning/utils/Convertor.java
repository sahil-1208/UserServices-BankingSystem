package com.learning.utils;

import org.springframework.stereotype.Component;

import com.learning.entity.UserEntity;
import com.learning.model.UserRequest;
import com.learning.model.UserResponse;

@Component
public class Convertor {
	
	public UserEntity requestToEntity(UserRequest userRequest) {
		UserEntity userEntity = new UserEntity();
		userEntity.setName(userRequest.getName());
		userEntity.setMobileNumber(userRequest.getMobileNumber());
		userEntity.setEmail(userRequest.getEmail());
		return userEntity;
	}
	
	public UserResponse entityToResponse(UserEntity userEntity) {
		UserResponse userResponse = new UserResponse();
		userResponse.setId(userEntity.getId());
		userResponse.setName(userEntity.getName());
		userResponse.setMobileNumber(userEntity.getMobileNumber());
		userResponse.setEmail(userEntity.getEmail());
		return userResponse;
	}
	
	public UserEntity updateEntity(UserRequest userRequest, UserEntity userEntity) {
		userEntity.setName(userRequest.getName());
		userEntity.setMobileNumber(userRequest.getMobileNumber());
		userEntity.setEmail(userRequest.getEmail());
		return userEntity;
	}

}
