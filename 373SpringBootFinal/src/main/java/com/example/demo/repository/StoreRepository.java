package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Store;

public interface StoreRepository
	extends JpaRepository<Store, String>{
// type and the type for the primary key to access the type
}
//select avg(rating), store.name from store where store.name = :name"
//select * from boba where name = :name