package com.example.shopping.service;

import java.util.List;

import com.example.shopping.model.Request;
import com.example.shopping.model.Response;


public interface ShoppingService {
	
	public List<Request> getproducts(String name);
	

}
