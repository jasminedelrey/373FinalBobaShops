package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Shipment;
import com.example.demo.model.Store;

public interface ShipmentRepository
	extends JpaRepository<Shipment, String>{
	@Query(value = "select * from shipment where year(shipment.date_arrival) = :year order by shipment.price desc", nativeQuery = true)
    List<Shipment> findShipmentsByYear(@Param("year") String year);
// type and the type for the primary key to access the type
}
//select avg(rating), store.name from store where store.name = :name"
//select * from boba where name = :name