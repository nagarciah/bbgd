package com.neuronkids.products.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Product {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull(message="El producto debe tener un nombre")
	@Size(min=5, max=20)
	private String name;
	private String description;

	public Product() {

	}

	public Product(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [id=")
			.append(id)
			.append(", name=")
			.append(name)
			.append(", description=")
			.append(description)
			.append("]");
		return builder.toString();
	}

}
