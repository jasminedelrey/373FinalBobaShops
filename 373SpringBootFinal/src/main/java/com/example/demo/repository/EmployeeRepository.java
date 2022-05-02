package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Employee;

public interface EmployeeRepository 
	extends JpaRepository<Employee, Integer>{
	@Query(value = "select * from employee where employee.home_store_id = :store_id", nativeQuery = true)
    List<Employee> findEmployeesByStore(@Param("store_id") String store_id);
// type and the type for the primary key to access the type
}
