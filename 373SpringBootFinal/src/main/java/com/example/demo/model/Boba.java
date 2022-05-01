package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="boba")
public class Boba {
	
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private long boba_id;
	
	@Column(name = "name") private String name;
	
	@Column(name ="price") private Float price;
	
	@Column(name ="review") private Float review;
	
	public Boba () {}
	
	public Boba(String name, Float price, Float review) {
		this.name = name;
		this.price = price;
		this.review = review;
	}
	
	public long getBoba_id() {
		return boba_id;
	}
	
	public String getName() {
		return name;
	}
	
	public Float getPrice() {
		return price;
	}
	
	public Float getReview() {
		return review;
	}
	
	public void setBoba_id(long boba_id) {
		this.boba_id = boba_id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(Float price) {
		this.price = price;
	}
	
	public void setReview(Float price) {
		this.review = review;
	}
	

}
