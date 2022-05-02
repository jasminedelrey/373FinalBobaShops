package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.misc.ResourceNotFoundException;
import com.example.demo.model.Inventory;
import com.example.demo.repository.InventoryRepository;

@RestController
@RequestMapping("/api/v1/")
// http://localhost:8080/api/v1/
public class InventoryController {

	@Autowired
	private InventoryRepository inventoryRepository;
	
	// HTTP requests:
		// GET: not changing the db; retrieving data from db
		// POST: send data to db to be recorded
	// write a method that returns all the employees information
	// http://localhost:8080/api/v1/employees
	@GetMapping("/all-inventory")
	public List<Inventory> getAllInventory(){
		return inventoryRepository.findAll();
		// select * from employee
	}
	
	// write a method that adds an employee to the db
	// when sending data to your server
	// it is better to send it in a request body
	// http://localhost:8080/api/v1/addemployee
	@PostMapping("/addinventory")
	public Inventory addInventory(@RequestBody Inventory e) {
		return inventoryRepository.save(e);
		// insert into employee (home_store_id, name, phone, email, address)
		// values (e.home_store_id, e.name, e.phone, e.email, e.address)
	}
	
	
}