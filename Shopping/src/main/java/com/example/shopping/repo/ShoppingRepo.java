package com.example.shopping.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.shopping.model.Request;

@Repository
public interface ShoppingRepo extends JpaRepository<Request, Long> {

	public List<Request> findAll();
}
