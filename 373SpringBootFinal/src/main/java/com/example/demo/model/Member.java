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

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer member_id;
	@Column(name="name") private String name;
	@Column(name="phone") private Integer phone;
	@Column(name="email") private String email;
	@Column(name="address") private String address;
	@Column(name="date_init")private Date date_init;
	
	public Member() {}
	public Member(Integer member_id, String name, Integer phone, String email, String address, Date date_init) {
		this.member_id = member_id;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.date_init = date_init;
	}
}
