package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="inventory")

public class Inventory {

	@Column(name="store_id") private String store_id;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer ingredient_id;
	@Column(name="quantity") private Integer quantity;
	
//	@ManyToOne
//	@JoinColumn(name="store_id", nullable = false)
//	private Store store;
	
	public Inventory() {
	
	}
	
	public Inventory(Integer quantity, String store_id) {
		this.quantity = quantity;
		this.store_id = store_id;
	}
	
	public Integer getIngredient_id() {
		return ingredient_id;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public String getStore_id() {
		return store_id;
	}
	
	public void setIngredient_id(Integer ingredient_id) {
		this.ingredient_id = ingredient_id;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public void setStore_id(String store_id) {
		this.store_id = store_id;
	}
	
	
}
