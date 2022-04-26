package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="inventory")

public class Inventory implements Serializable {

	@Id private Integer store_id;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer ingredient_id;
	@Column(name="quantity") private Integer quantity;
	
	public Inventory() {
	
	}
	
	public Inventory(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Integer getIngredient_id() {
		return ingredient_id;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public Integer getStore_id() {
		return store_id;
	}
	
	public void setIngredient_id(Integer ingredient_id) {
		this.ingredient_id = ingredient_id;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}
	
	
}
