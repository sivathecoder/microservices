package com.example.stock.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stock.model.StockModel;

@Repository
public interface Stockrepo extends JpaRepository<StockModel, Object> {

	public List<StockModel> findAll();
}
