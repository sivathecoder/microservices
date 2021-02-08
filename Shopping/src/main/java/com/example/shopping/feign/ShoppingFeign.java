package com.example.shopping.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.shopping.model.StockModel;

@FeignClient(name ="stock")
public interface ShoppingFeign {

	@GetMapping("/stock/getAll")
	public List<StockModel> getStocks();
	
	@GetMapping("/stock/{name}/count")
	public Integer getCount(@PathVariable String name);
}
