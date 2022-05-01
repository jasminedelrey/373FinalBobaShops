package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.misc.ResourceNotFoundException;
import com.example.demo.model.Boba;
import com.example.demo.model.Employee;
import com.example.demo.repository.BobaRepository;

@RestController
@RequestMapping("/api/v1/")
// http://localhost:8080/api/v1/
public class BobaController {

	@Autowired
	private BobaRepository bobaRepository;
	
	// HTTP requests:
		// GET: not changing the db; retrieving data from db
		// POST: send data to db to be recorded
	// write a method that returns all the boba information
	// http://localhost:8080/api/v1/boba
	@GetMapping("/boba")
	public List<Boba> getAllBoba(){
		return bobaRepository.findAll();
		// select * from boba
	}
	
	// write a method to return information for a boba drink by boba id
		@GetMapping("/boba/{boba_id}")
		public ResponseEntity<Boba> 
					getBobaById(@PathVariable String boba_id) {
			// findById(id)
			Boba boba = bobaRepository.findById(boba_id)
					.orElseThrow( 
							() -> new ResourceNotFoundException("Boba id" 
													+ boba_id + " not found"));	
			return ResponseEntity.ok(boba);		
		}
		
		//write a method to get boba information by name, and sort by review
		
		@GetMapping("/find-boba-name/{name}")
		public List<Boba> getBobaByName(@PathVariable("name") String name) {
			return bobaRepository.findBobaByName(name);
		}
		
	
}
	

