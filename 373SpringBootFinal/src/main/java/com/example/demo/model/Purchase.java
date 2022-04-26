package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="purchase")

public class Purchase {
	
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer Purchase_id;
	
	@Column(name = "Date") private Date Date;
	@Column(name ="Boba_id") private Integer Boba_id;
	@Column(name="Quantity") private Integer Quantity;
	@Column(name="Price") private Integer Price;	
	@Column(name="member_id") private Integer member_id;
	@Column(name="isMember") private boolean isMember;
    @Column(name="Store_id") private Integer Store_id;

	public Purchase () {}
	
	public Purchase (Date Date, Integer Boba_id, Integer Quantity, Integer Price, Integer member_id,  boolean isMember, Integer Store_id ) {
		this.Date = Date;
		this.Boba_id = Boba_id;
		this.Quantity = Quantity;
		this.Price = Price;
		this.member_id = member_id;
        this.isMember = isMember;
        this.Store_id = Store_id;
	}
	
	public Date getDate() {
		return Date;
	}
    public Integer getBoba_id() {
		return Boba_id;
	}
    public Integer getQuantity() {
		return Quantity;
	}
    public Integer getPrice() {
		return Price;
	}
    public Integer getMemberId() {
		return member_id;
	}
    public boolean isMember() {
		return isMember;
	}
    public Integer getStoreId() {
		return Store_id;
	}

    public void setDate(Date Date) {
		this.Date = Date;
	}
	public void setPurchaseId(Integer Purchase_id) {
		this.Purchase_id = Purchase_id;
	}
	public void setBoba_id(Integer Boba_id) {
		this.Boba_id = Boba_id;
	}
    public void setQuantity(Integer Quantity) {
		this.Quantity = Quantity;
	}
    public void setPrice(Integer Price) {
		this.Price = Price;
	}
	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}
    public void setIsMember(boolean isMember) {
		this.isMember = isMember;
    }
    public void setStore_id(Integer Store_id) {
		this.Store_id = Store_id;
	}


	
	
}
