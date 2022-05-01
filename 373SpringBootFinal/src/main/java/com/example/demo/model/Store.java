package com.example.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="store")
public class Store {
	
	@Id private String store_id;
	@Column(name="name") private String name;
	@Column(name="rating") private Float rating;
	@Column(name="address") private String address;
	@Column(name="city") private String city;
	
//	@OneToMany(mappedBy = "store")
//	private List<Inventory> inventory;
	
	public Store() {}
	
	public Store(String name, String city, Float rating, String address) {
		this.name = name;
		this.rating = rating;
		this.address = address;
		this.city = city;
	}
	
	public String getAddress() {
		return address;
	}
	
	
	public String getName() {
		return name;
	}
	
	public String getCity() {
		return city;
	}
	
	public Float getRating() {
		return rating;
	}
	
	public String getStore_id() {
		return store_id;
	}
	
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	public void setRating(Float rating) {
		this.rating = rating;
	}
	public void setStore_id(String store_id) {
		this.store_id = store_id;
	}
	
	

}
