package com.productDetails.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productDetails.entity.ProductDetailsEntity;

public interface productDetailsRepository extends JpaRepository<ProductDetailsEntity, Integer>{

}
