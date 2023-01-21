package com.desidukaan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desidukaan.model.ProductDTO;

public interface ProductDtoDao extends JpaRepository<ProductDTO, Integer> {

}
