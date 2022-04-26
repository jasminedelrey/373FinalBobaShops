package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shipment")
public class Shipment {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer order_id;
	@Column(name="shipment_number") private Integer shipment_number;
	@Column(name="ingredient_id") private Integer ingredient_id;
	@Column(name="quantity") private Integer quantity;
	@Column(name="store_id") private Integer store_id;
	@Column(name="datetime") private Date datetime;
	
	public Shipment() {}
	public Shipment(Integer shipment_number, Integer ingredient_id, Integer quantity, Integer store_id, Date datetime) {
		this.shipment_number = shipment_number;
		this.ingredient_id = ingredient_id;
		this.quantity = quantity;
		this.store_id = store_id;
		this.datetime = datetime;
	}
	
	public Date getDatetime() {
		return datetime;
	}
	
	public Integer getIngredient_id() {
		return ingredient_id;
	}
	
	public Integer getOrder_id() {
		return order_id;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public Integer getShipment_number() {
		return shipment_number;
	}
	
	public Integer getStore_id() {
		return store_id;
	}
	
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	
	public void setIngredient_id(Integer ingredient_id) {
		this.ingredient_id = ingredient_id;
	}
	
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public void setShipment_number(Integer shipment_number) {
		this.shipment_number = shipment_number;
	}
	
	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}
	

}
