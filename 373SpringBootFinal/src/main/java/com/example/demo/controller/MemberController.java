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
import com.example.demo.model.Member;
import com.example.demo.repository.MemberRepository;

@RestController
@RequestMapping("/api/v1/")
// http://localhost:8080/api/v1/
public class MemberController {

	@Autowired
	private MemberRepository memberRepository;
	
	// HTTP requests:
		// GET: not changing the db; retrieving data from db
		// POST: send data to db to be recorded
	// write a method that returns all the employees information
	// http://localhost:8080/api/v1/employees
	@GetMapping("/member")
	public List<Member> getAllMembers(){
		return memberRepository.findAll();
		// select * from employee
	}
}
	
	// write a method that adds an employee to the db
	// when sending data to your server
	// it is better to send it in a request body
	// http://localhost:8080/api/v1/addemployee
//	@PostMapping("/addemployee")
//	public Member addEmployee(@RequestBody Member e) {
//		return memberRepository.save(e);
		// insert into employee (home_store_id, name, phone, email, address)
		// values (e.home_store_id, e.name, e.phone, e.email, e.address)
//	}
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
	
	
	// update an employee 
//	@PutMapping("/member/{member_id}") // You can have the same api path but different request methods
//	public ResponseEntity<Member> updateEmployee(@PathVariable Integer member_id, @RequestBody Member updatedE){
//		Employee employee = memberRepository.findById(member_id)
//				.orElseThrow(() -> new ResourceNotFoundException("Member " + member_id + " not found."));
//		
//		employee.setName(updatedE.getName());
//		employee.setPhone(updatedE.getPhone());
//		employee.setEmail(updatedE.getEmail());
//		employee.setAddress(updatedE.getAddress());
//		employee.setHome_store_id(updatedE.getHome_store_id());
//		Employee updatedEmployee = employeeRepository.save(employee);
//		return ResponseEntity.ok(updatedEmployee);
//	}
	
	// delete an employee
//	@DeleteMapping("/employees/{emp_id}")
//	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Integer emp_id){
//		
//		Employee employee = employeeRepository.findById(emp_id)
//				.orElseThrow(() -> new ResourceNotFoundException("Employee " + emp_id + " not found."));
//		
//		employeeRepository.delete(employee);
//		Map<String, Boolean> response = new HashMap<>();
//		response.put(employee.getEmp_id()+" is deleted", true);
//		return ResponseEntity.ok(response);
//	}
//	
