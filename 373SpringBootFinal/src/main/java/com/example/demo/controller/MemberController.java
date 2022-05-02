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
	
	// return member's list of purchases.
	
	// delete an employee
	@DeleteMapping("p")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable String member_id){
		
		Member member = memberRepository.findById(member_id)
				.orElseThrow(() -> new ResourceNotFoundException("Member " + member_id + " not found."));
		
		memberRepository.delete(member);
		Map<String, Boolean> response = new HashMap<>();
		response.put(member.getMember_id()+" is deleted", true);
		return ResponseEntity.ok(response);
	}
}
//	
