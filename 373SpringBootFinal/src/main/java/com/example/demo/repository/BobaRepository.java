package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Boba;

public interface BobaRepository 
	extends JpaRepository<Boba, String>{
	@Query(value = "select * from boba where boba.name = :name order by boba.review desc", nativeQuery = true)
    List<Boba> findBobaByName(@Param("name") String name);
// type and the type for the primary key to access the type
}
//select avg(rating), store.name from store where store.name = :name"
//select * from boba where name = :name