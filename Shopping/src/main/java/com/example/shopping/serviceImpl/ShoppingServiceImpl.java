package com.example.shopping.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.shopping.model.Response;
import com.example.shopping.model.Request;
import com.example.shopping.repo.ShoppingRepo;
import com.example.shopping.service.ShoppingService;

@Component
public class ShoppingServiceImpl implements ShoppingService {

	@Autowired
	ShoppingRepo repo;
	
	public List<Request> getproducts(String name) {
		List<Request> response= repo.findAll();
		return response;
	}

	public Request saveProducts(Request request) {
		
		return repo.save(request);
	}

	public void buyProduct(String name) {
		
		
	}

}
