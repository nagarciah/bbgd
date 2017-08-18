package com.neuronkids.products.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neuronkids.products.entity.Product;
import com.neuronkids.products.service.ProductService;

@RestController
public class ProductsApi {
	
	@Autowired
	private ProductService productService;

	/**
	 * http://localhost:8080/product/3
	 * @param id
	 * @return
	 */
	@RequestMapping("/product/{myId}/{nombre}")
	public Product getById(@PathVariable(name="myId") Long id, @PathVariable String nombre){
		System.out.println("El nombre es " + nombre);
		return productService.getById(id);
	}

	/**
	 * Modo de invocacion: http://localhost:8080/product?id=3&nombre=nelson
	 * @param id
	 * @return
	 */
	@RequestMapping("/product")
	public Product getByIdUsingRequestParam(@RequestParam Long id, @RequestParam String nombre){
		System.out.println("El nombre es " + nombre);
		return productService.getById(id);
	}

	
	@RequestMapping("/products")
	public List<Product> getAll(){
		return productService.getAll();
	}
	
	
	@RequestMapping(value="/product", method=RequestMethod.POST)
	public Product save(@RequestBody @Valid Product product){
		return productService.save(product);
	}
	

	@RequestMapping("/products/{nameLike}")
	public List<Product> getAllWithNameLike(@PathVariable String nameLike){
		return productService.getByName(nameLike);
	}

}


