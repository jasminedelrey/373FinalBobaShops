package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="member")
public class Member {

	@Id private String member_id;
	@Column(name="name") private String name;
	@Column(name="phone") private Integer phone;
	@Column(name="email") private String email;
	@Column(name="address") private String address;
	@Column(name="year_init")private Integer year_init;
	@Column(name="month_init")private Integer month_init;
	@Column(name="day_init")private Integer day_init;
	
	public Member() {}
	public Member(String member_id, String name, Integer phone, String email, String address, Integer year_init,
			Integer month_init, Integer day_init) {
		this.member_id = member_id;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.year_init = year_init;
		this.month_init = month_init;
		this.day_init = day_init;
	}
	
	public String getAddress() {
		return address;
	}
	
	public Integer getYear_init() {
		return year_init;
	}
	
	public Integer getMonth_init() {
		return month_init;
	}
	
	public Integer getDay_init() {
		return day_init;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getMember_id() {
		return member_id;
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getPhone() {
		return phone;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setDay_init(Integer day_init) {
		this.day_init = day_init;
	}
	
	public void setMonth_init(Integer month_init) {
		this.month_init = month_init;
	}
	
	public void setYear_init(Integer year_init) {
		this.year_init = year_init;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	
}
