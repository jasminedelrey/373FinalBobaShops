package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Boba;
import com.example.demo.model.Store;

public interface StoreRepository
	extends JpaRepository<Store, String>{
	@Query(value = "select * from store where store.city = :city order by store.rating desc", nativeQuery = true)
    List<Store> findStoresByCity(@Param("city") String city);
// type and the type for the primary key to access the type
}
//select avg(rating), store.name from store where store.name = :name"
//select * from boba where name = :name