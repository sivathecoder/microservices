package com.example.stock.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.stock.controller.StockController;
import com.example.stock.model.StockModel;
import com.example.stock.repo.Stockrepo;
import com.example.stock.service.StockInterface;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class StockImpl implements StockInterface{

	@Autowired
	Stockrepo repo;
	Logger logger = LoggerFactory.getLogger(StockController.class);
	
	@HystrixCommand(fallbackMethod = "getStockCountFallback")
	public Integer getStockCount(String name) {
	 
		logger.info("inside stockcountimpl");
		List<StockModel> list= repo.findAll().stream().filter(n->n.getName().equals(name)).collect(Collectors.toList());
		System.out.println(list);
		return list.get(0).getCount();
	}

	public List<StockModel> getAll() {
		logger.info("inside getAll");
		return repo.findAll();
	}
	
	public Integer getStockCountFallback(String name) {
		return 0;
		
	}

}
