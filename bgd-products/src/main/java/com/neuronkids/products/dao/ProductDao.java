package com.neuronkids.products.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.neuronkids.products.entity.Product;

public interface ProductDao extends JpaRepository<Product, Long> {

	List<Product> findByNameLike(String string);

}
