package com.neuronkids.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuronkids.products.dao.ProductDao;
import com.neuronkids.products.entity.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDao dao;
	
	public List<Product> getAll(){
		return dao.findAll();
	}
	
	public Product getById(Long id){
		return dao.findOne(id);
	}

	public Product save(Product product) {
		return dao.saveAndFlush(product);
	}
	
	public List<Product> getByName(String name){
		StringBuilder sb = new StringBuilder();
		sb.append("%")
		.append(name)
		.append("%");
				
		return dao.findByNameLike(sb.toString());
	}
		
}
