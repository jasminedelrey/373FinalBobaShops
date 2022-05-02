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
import com.example.demo.model.Shipment;
import com.example.demo.repository.ShipmentRepository;
@RestController
@RequestMapping("/api/v1/")
// http://localhost:8080/api/v1/
public class ShipmentController {

	@Autowired
	private ShipmentRepository shipmentRepository;
	
	// HTTP requests:
		// GET: not changing the db; retrieving data from db
		// POST: send data to db to be recorded
	// write a method that returns all the employees information
	// http://localhost:8080/api/v1/employees
	@GetMapping("/shipments")
	public List<Shipment> getAllShipments(){
		return shipmentRepository.findAll();
		// select * from employee
	}
	
	// write a method that adds an employee to the db
	// when sending data to your server
	// it is better to send it in a request body
	// http://localhost:8080/api/v1/addemployee
	@PostMapping("/addshipment")
	public Shipment addShipment(@RequestBody Shipment e) {
		return shipmentRepository.save(e);
		// insert into employee (home_store_id, name, phone, email, address)
		// values (e.home_store_id, e.name, e.phone, e.email, e.address)
	}
	// http://localhost:8080/api/v1/employee/{id}

	// write a method to return an employee by its id
//	@GetMapping("/employee/{emp_id}")
//	public ResponseEntity<Employee> 
//				getEmployeeById(@PathVariable Integer emp_id) {
//		// findById(id)
//		Employee employee = employeeRepository.findById(emp_id)
//				.orElseThrow( 
//						() -> new ResourceNotFoundException("Employee #" 
//												+ emp_id + " not found"));	
//		return ResponseEntity.ok(employee);		
//	}
//	
	//write a method to return shipments by year
	
	@GetMapping("/find-shipments-by-year/{year}")
	public List<Shipment> getShipmentsByYear(@PathVariable("year") String year) {
		return shipmentRepository.findShipmentsByYear(year);
	}
	
	

	
}