package com.nagarro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.entity.RepliesEntity;

public interface RepliesRepository extends JpaRepository<RepliesEntity, Integer>{

}
