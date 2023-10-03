package com.learning.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
