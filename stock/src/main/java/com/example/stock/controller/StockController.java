package com.example.stock.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stock.model.StockModel;
import com.example.stock.repo.Stockrepo;
import com.example.stock.serviceimpl.StockImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/stock")
public class StockController {

	@Autowired
	StockImpl impl;

	@Autowired
	Stockrepo repo;

	Logger logger = LoggerFactory.getLogger(StockController.class);

	@PostMapping("/savestock")
	public StockModel saveStock(@RequestBody StockModel model) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(model);
		logger.info(result);
		repo.save(model);
		return model;

	}

	@GetMapping("/create")
	public String createStock() {
		StockModel entity = new StockModel("baby", "cloth", 230, 50);
		repo.save(entity);
		return "created";

	}

	@GetMapping("/getAll")
	public List<StockModel> getStocks() {
		return impl.getAll();
	}

	@GetMapping("/{name}/count")
	public Integer getCount(@PathVariable String name) {
		Integer count = repo.findAll().stream().filter(n -> n.getName().equals(name)).collect(Collectors.toList())
				.get(0).getCount();
		StockModel model = repo.findAll().stream().filter(n -> n.getName().equals(name)).collect(Collectors.toList())
				.get(0);
		if (count > 0) {
			model.setCount(count - 1);
			repo.save(model);
		}
		return count;
	}

	@GetMapping("/getstockcount/{name}")
	public Integer getStockCount(@PathVariable String name) {
		logger.info("inside getstockcount");
		return impl.getStockCount(name);
	}

}
