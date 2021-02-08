package com.example.shopping.model;

import javax.persistence.Id;

import lombok.Data;

public class Response {
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}



	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	private String name;
	
	private String category;
	
	
	private Integer price;
}
