package com.example.shopping.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.shopping.feign.ShoppingFeign;
import com.example.shopping.model.Request;
import com.example.shopping.model.Response;
import com.example.shopping.model.StockModel;
import com.example.shopping.repo.ShoppingRepo;
import com.example.shopping.serviceImpl.ShoppingServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/shopping")
public class ShoppingController {
	
	@Autowired
	ShoppingServiceImpl impl;
	
	@Autowired
	ShoppingRepo repo;
	
	@Autowired
	ShoppingFeign feign;
	
	Logger logger= LoggerFactory.getLogger(ShoppingController.class);
	
	List<Response> result = new ArrayList<Response>();
	
@GetMapping("/getAll/{category}")
public ResponseEntity<List<Response>> getProducts(@PathVariable String category) {
	List<StockModel> stocks= feign.getStocks();
	stocks=stocks.stream().filter(n->n.getCategory().equals(category)).collect(Collectors.toList());
	
	System.out.println("--------------------"+stocks.size());
	
	for(StockModel i:stocks)
	{
		Response response = new Response();
		response.setName(i.getName());
		response.setCategory(i.getCategory());
		response.setPrice(i.getPrice());
		result.add(response);
		
	}
	
	return new ResponseEntity<List<Response>>(result, HttpStatus.OK);
}


@GetMapping("/buy/{name}")
public ResponseEntity<String> buyProduct(@PathVariable String name){
	String failure="NOT AVAILABLE";
	Integer count = feign.getCount(name);
	if(count>0)
		return new ResponseEntity<String>("success", HttpStatus.OK); 
	else
		return new ResponseEntity<String>(failure, HttpStatus.OK);
	
	
}
	
}
	