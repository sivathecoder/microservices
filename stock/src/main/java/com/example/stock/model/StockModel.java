package com.example.stock.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class StockModel {

	
	
	@Id
	private String name;
	
	public StockModel(String name, String category, Integer price, Integer count) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
		this.count = count;
	}

	private String category;
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public StockModel() {
		super();
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	private Integer price;
	
	private Integer count;

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
}
