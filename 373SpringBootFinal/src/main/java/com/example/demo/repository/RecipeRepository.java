package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Recipe;

public interface RecipeRepository
	extends JpaRepository<Recipe, String>{
	@Query(value = "select * from recipe where recipe.store_id = :store_id", nativeQuery = true)
    List<Recipe> findRecipeByStore(@Param("store_id") String store_id);
// type and the type for the primary key to access the type
}
//select avg(rating), store.name from store where store.name = :name"
//select * from boba where name = :name