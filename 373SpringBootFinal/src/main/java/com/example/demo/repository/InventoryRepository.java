package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Inventory;

public interface InventoryRepository
	extends JpaRepository<Inventory, Integer>{
// type and the type for the primary key to access the type
}
//select avg(rating), store.name from store where store.name = :name"
//select * from boba where name = :name