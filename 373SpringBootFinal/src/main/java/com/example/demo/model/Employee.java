package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")

public class Employee {
	
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer emp_id;
	
	@Column(name = "home_store_id") private Integer home_store_id;
	
	@Column(name ="name") private String name;
	
	@Column(name="phone") private Integer phone;
	
	@Column(name="email") private String email;
	
	@Column(name="address") private String address;
	
	public Employee () {}
	
	public Employee (Integer home_store_id, String name, Integer phone, String email, String address) {
		this.home_store_id = home_store_id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Integer getEmp_id() {
		return emp_id;
	}
	
	public Integer getHome_store_id() {
		return home_store_id;
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getPhone() {
		return phone;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}
	
	public void setHome_store_id(Integer home_store_id) {
		this.home_store_id = home_store_id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	
	
}
