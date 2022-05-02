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
import com.example.demo.model.Boba;
import com.example.demo.model.Store;
import com.example.demo.repository.StoreRepository;

@RestController
@RequestMapping("/api/v1/")
// http://localhost:8080/api/v1/
public class StoreController {

	@Autowired
	private StoreRepository storeRepository;
	
	// HTTP requests:
		// GET: not changing the db; retrieving data from db
		// POST: send data to db to be recorded
	// write a method that returns all the employees information
	// http://localhost:8080/api/v1/employees
	@GetMapping("/stores")
	public List<Store> getAllStore(){
		return storeRepository.findAll();
		// select * from employee
	}
	
	// write a method that adds an employee to the db
	// when sending data to your server
	// it is better to send it in a request body
	// http://localhost:8080/api/v1/addemployee
	@PostMapping("/addstore")
	public Store addStore(@RequestBody Store e) {
		return storeRepository.save(e);
		// insert into employee (home_store_id, name, phone, email, address)
		// values (e.home_store_id, e.name, e.phone, e.email, e.address)
	}
	// http://localhost:8080/api/v1/employee/{id}
	
	
	// update a store's review~
	@PutMapping("/stores/{store_id}") // You can have the same api path but different request methods
	public ResponseEntity<Store> updateStore(@PathVariable String store_id, @RequestBody Store updatedS){
		Store store = storeRepository.findById(store_id)
				.orElseThrow(() -> new ResourceNotFoundException("Store " + store_id + " not found."));
		
		store.setRating(updatedS.getRating());
		Store updatedStore = storeRepository.save(store);
		return ResponseEntity.ok(updatedStore);
	}
	
	// delete a store // delete employees!
	@DeleteMapping("/delete-store/{store_id}")
	public ResponseEntity<Map<String, Boolean>> deleteStore(@PathVariable String store_id){
		
		Store store = storeRepository.findById(store_id)
				.orElseThrow(() -> new ResourceNotFoundException("Store " + store_id + " not found."));
		
		storeRepository.delete(store);
		Map<String, Boolean> response = new HashMap<>();
		response.put(store.getStore_id()+" is deleted", true);
		return ResponseEntity.ok(response);
	}
	
	// return stores sort by review
	@GetMapping("/find-store-by-city/{city}")
	public List<Store> getStoresByCity(@PathVariable("city") String city) {
		return storeRepository.findStoresByCity(city);
	}
	
}