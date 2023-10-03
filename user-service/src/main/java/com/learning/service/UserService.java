package com.learning.service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entity.UserEntity;
import com.learning.enums.Status;
import com.learning.model.UserRequest;
import com.learning.model.UserResponse;
import com.learning.repo.UserRepository;
import com.learning.utils.Convertor;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private Convertor convertor;
	
	public UserResponse create(UserRequest userRequest) {
		UserResponse userResponse = null;
		if (Objects.nonNull(userRequest)) {
			UserEntity userEntity = convertor.requestToEntity(userRequest);
			userEntity = userRepo.save(userEntity);
			userResponse = convertor.entityToResponse(userEntity);
		}
		return userResponse;
	}

	public UserResponse findUserById(Long id) {
		UserResponse userResponse = null;
		Optional<UserEntity> optionalEntity = userRepo.findById(id);
		if (optionalEntity.isPresent()) {
			UserEntity userEntity = optionalEntity.get();
			userResponse = convertor.entityToResponse(userEntity);
		}
		return userResponse;
	}
	
	public UserResponse update(Long id, UserRequest userRequest) {
		UserResponse userResponse = null;
		Optional<UserEntity> optionalEntity = userRepo.findById(id);
		if (optionalEntity.isPresent()) {
			UserEntity userEntity = optionalEntity.get();
			userEntity = convertor.updateEntity(userRequest, userEntity);
			userEntity = userRepo.save(userEntity);
			userResponse = convertor.entityToResponse(userEntity);
		}
		return userResponse;
	}
	
	public Status deleteUserById(Long id) {
		Optional<UserEntity> optionalEntity = userRepo.findById(id);
		if (optionalEntity.isPresent()) {
			userRepo.deleteById(id);
			return Status.SUCCESS;
		} 
		return Status.FAILED;
	}
	
	


}
