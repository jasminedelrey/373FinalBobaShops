package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Employee;

public interface EmployeeRepository 
	extends JpaRepository<Employee, Integer>{
// type and the type for the primary key to access the type
}
