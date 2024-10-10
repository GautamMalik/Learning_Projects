package com.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.enity.userEntity;

public interface userRepository extends JpaRepository<userEntity, Integer>{

}
