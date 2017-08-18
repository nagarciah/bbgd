package com.neuronkids.products;

import static org.junit.Assert.*;
import static org.mockito.Matchers.isNotNull;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;

import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.neuronkids.products.entity.Product;


public class ProductApiIT {

	@Test
	public void productsList() {
		RestAssured
		.given() // -> Arrange (preparar el llamado)
			.contentType(ContentType.JSON)
			.log().all()
		.when()  // -> Act (ejecutar el llamado)
			.get("/products")
		.then()	// -> Assert (verificar el resultado)
			.log().all()
			.statusCode(200)
			.contentType(ContentType.JSON)
			.body("name", hasSize(greaterThan(0)))
		; 
	}

	@Test
	public void saveProduct() {
		
		Product p = new Product(null, "myProduct", "product desde el test");
		
		RestAssured
		.given() // -> Arrange (preparar el llamado)
			.contentType(ContentType.JSON)
			.body(p)
			.log().all()
		.when()  // -> Act (ejecutar el llamado)
			.post("/product")
		.then()	// -> Assert (verificar el resultado)
			.log().all()
			.statusCode(200)
			.contentType(ContentType.JSON)
			.body("name", is(p.getName()))
			.body("id", notNullValue())
		; 
	}
	
	

	@Test
	public void validateNameLength() {
		
		Product p = new Product(null, "este es un nombre muy largo", "product desde el test");
		
		RestAssured
		.given() // -> Arrange (preparar el llamado)
			.contentType(ContentType.JSON)
			.body(p)
			.log().all()
		.when()  // -> Act (ejecutar el llamado)
			.post("/product")
		.then()	// -> Assert (verificar el resultado)
			.log().all()
			.statusCode(400)
			.contentType(ContentType.JSON)
		; 
	}
}
