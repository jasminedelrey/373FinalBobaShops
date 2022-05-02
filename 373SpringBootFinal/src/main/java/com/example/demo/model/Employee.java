package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee")

public class Employee {
	
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer emp_id;

	@Column(name="address") private String address;
	
	@Column(name="email") private String email;
	
	@Column(name = "home_store_id") private String home_store_id;
	
	@Column(name ="name") private String name;
	
	@Column(name="phone") private String phone;
	
//	@OneToOne
//	@JoinColumn(foreignKey = @ForeignKey(name="home_store_id", foreignKeyDefinition = "foreign key /* FK */ (store_id) references Store"))
//	public Store store;
	
//	@OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "store_id", referencedColumnName = "home_store_id")
//    private Store store;

	
	public Employee () {}
	
	public Employee (Integer emp_id, String home_store_id, String name, String phone, String email, String address) {
		this.emp_id = emp_id;
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
	
	public String getHome_store_id() {
		return home_store_id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPhone() {
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
	
	public void setHome_store_id(String home_store_id) {
		this.home_store_id = home_store_id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
