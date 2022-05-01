package com.example.demo.model;

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
import java.util.Date;

@Entity
@Table(name="purchase")

public class Purchase {
	
@Id private String id;
	
	@Column(name = "purchase_id") private String purchase_id;
	@Column(name = "Year") private Integer year;
	@Column(name = "Month") private Integer month;
	@Column(name = "Day") private Integer day;
	@Column(name ="Boba_id") private Integer Boba_id;
	@Column(name="Quantity") private Integer Quantity;
	@Column(name="Price") private Float Price;	
	@Column(name="isMember") private boolean isMember;
	@Column(name="member_id") private String member_id;
    @Column(name="Store_id") private String Store_id;
    
//	@ManyToOne
//	@JoinColumn(foreignKey = @ForeignKey(name="member_id", foreignKeyDefinition = "foreign key /* FK */ (member_id) references Member"))
//	public Member member;

	public Purchase () {}
	
	public Purchase (Integer year, Integer month, Integer day, Integer Boba_id, Integer Quantity, Float Price, String member_id,  boolean isMember, String Store_id ) {
		this.purchase_id = purchase_id;
		this.month = month;
		this.year = year;
		this.day = day;
		this.Boba_id = Boba_id;
		this.Quantity = Quantity;
		this.Price = Price;
		this.member_id = member_id;
        this.isMember = isMember;
        this.Store_id = Store_id;
	}
	
	public Integer getDay() {
		return day;
	}
	public String getId() {
		return id;
	}
	public Integer getMonth() {
		return month;
	}
	public Integer getYear() {
		return year;
	}
	
    public Integer getBoba_id() {
		return Boba_id;
	}
    public Integer getQuantity() {
		return Quantity;
	}
    public Float getPrice() {
		return Price;
	}
    public String getMemberId() {
		return member_id;
	}
    public boolean isMember() {
		return isMember;
	}
    public String getStoreId() {
		return Store_id;
	}
    
    public String getPurchase_id() {
		return purchase_id;
	}
    
    public void setBoba_id(Integer boba_id) {
		Boba_id = boba_id;
	}
    public void setDay(Integer day) {
		this.day = day;
	}
    public void setId(String id) {
		this.id = id;
	}
    public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
    public void setMember(boolean isMember) {
		this.isMember = isMember;
	}
    public void setMonth(Integer month) {
		this.month = month;
	}
    public void setPrice(Float price) {
		Price = price;
	}
    public void setPurchase_id(String purchase_id) {
		this.purchase_id = purchase_id;
	}
    public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}
    public void setStore_id(String store_id) {
		Store_id = store_id;
	}
    public void setYear(Integer year) {
		this.year = year;
	}
    

   



	
	
}
