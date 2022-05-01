package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="shipment")
public class Shipment {
	
	@Id private String order_id;
	@Column(name="request_id") private Integer request_id;
	@Column(name="shipment_number") private Integer shipment_number;
	@Column(name="ingredient_id") private Integer ingredient_id;
	@Column(name="quantity") private Integer quantity;
	@Column(name="store_id") private String store_id;
	@Column(name="price") private Float price;
	@Column(name="date_arrival") private Date date_arrival;
	@Column(name="date_request") private Date date_request;
	
//	@ManyToOne
//	@JoinColumn(foreignKey = @ForeignKey(name="store_id", foreignKeyDefinition = "foreign key /* FK */ (store_id) references Store"))
//	public Store store;
//	
//	@ManyToMany
//	@JoinColumn(foreignKey = @ForeignKey(name="ingredient_id", foreignKeyDefinition = "foreign key /* FK */ (ingredient_id) references Inventory"))
//	public Store Inventory;
	
	
	public Shipment() {}
	public Shipment(Integer request_id, Integer shipment_number, Integer ingredient_id, Integer quantity, String store_id, Float price, Date date_arrival, Date date_request) {
		this.shipment_number = shipment_number;
		this.ingredient_id = ingredient_id;
		this.quantity = quantity;
		this.store_id = store_id;
		this.date_arrival = date_arrival;
		this.date_request = date_request;
		this.price = price;
		this.request_id = request_id;
	}
	
	public Date getDate_arrival() {
		return date_arrival;
	}
	
	public Date getDate_request() {
		return date_request;
	}
	
	public Integer getIngredient_id() {
		return ingredient_id;
	}
	
	public String getOrder_id() {
		return order_id;
	}
	
	public Float getPrice() {
		return price;
	}
	
	public Integer getRequest_id() {
		return request_id;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public Integer getShipment_number() {
		return shipment_number;
	}
	
	public String getStore_id() {
		return store_id;
	}
	
	public void setDate_arrival(Date date_arrival) {
		this.date_arrival = date_arrival;
	}
	
	public void setDate_request(Date date_request) {
		this.date_request = date_request;
	}
	
	public void setPrice(Float price) {
		this.price = price;
	}
	
	public void setRequest_id(Integer request_id) {
		this.request_id = request_id;
	}
	
	
	public void setIngredient_id(Integer ingredient_id) {
		this.ingredient_id = ingredient_id;
	}
	
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public void setShipment_number(Integer shipment_number) {
		this.shipment_number = shipment_number;
	}
	
	public void setStore_id(String store_id) {
		this.store_id = store_id;
	}
	

}
