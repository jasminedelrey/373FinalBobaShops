package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="store")
public class Store {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer store_id;
	@Column(name="name") private String name;
	@Column(name="email") private String email;
	@Column(name="address") private String address;
	
	public Store() {}
	
	public Store(String name, String email, String address) {
		this.name = name;
		this.email = email;
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getStore_id() {
		return store_id;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}

}
