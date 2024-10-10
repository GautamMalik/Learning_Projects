package com.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.entity.productEntity;

public interface productRepository extends JpaRepository<productEntity, Integer> {

}
