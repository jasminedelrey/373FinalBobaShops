package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.misc.ResourceNotFoundException;
import com.example.demo.model.Boba;
import com.example.demo.model.Recipe;
import com.example.demo.repository.RecipeRepository;

@RestController
@RequestMapping("/api/v1/")
// http://localhost:8080/api/v1/
public class RecipeController {

	@Autowired
	private RecipeRepository recipeRepository;
	
	// HTTP requests:
		// GET: not changing the db; retrieving data from db
		// POST: send data to db to be recorded
	// write a method that returns all the employees information
	// http://localhost:8080/api/v1/employees
	@GetMapping("/recipes")
	public List<Recipe> getAllRecipes(){
		return recipeRepository.findAll();
		// select * from employee
	}
	
	// write a method that adds an employee to the db
	// when sending data to your server
	// it is better to send it in a request body
	// http://localhost:8080/api/v1/addemployee
	@PostMapping("/addrecipe")
	public Recipe addRecipe(@RequestBody Recipe e) {
		return recipeRepository.save(e);
		// insert into employee (home_store_id, name, phone, email, address)
		// values (e.home_store_id, e.name, e.phone, e.email, e.address)
	}
	// http://localhost:8080/api/v1/employee/{id}

	// write a method to return a recipe by store id
	@GetMapping("/recipe/{store_id}")
	public List<Recipe> getRecipeByStore(@PathVariable("store_id") String store_id) {
		return recipeRepository.findRecipeByStore(store_id);
	}
	
	
	// update an employee 
	@PutMapping("/recipe/{boba_id}") // You can have the same api path but different request methods
	public ResponseEntity<Recipe> updateRecipe(@PathVariable String boba_id, @RequestBody Recipe updatedR){
		Recipe recipe = recipeRepository.findById(boba_id)
				.orElseThrow(() -> new ResourceNotFoundException("Recipe " + boba_id + " not found."));
		
		recipe.setIngredient_id(updatedR.getIngredientId());
		Recipe updatedRecipe = recipeRepository.save(recipe);
		return ResponseEntity.ok(updatedRecipe);
	}
	
	// THIS SHOULD ALSO DELETE FROM BOBA TABLE AND INVENTORY TABLE
	// delete an employee
//	@DeleteMapping("/employees/{emp_id}")
//	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Integer emp_id){
//		
//		Employee employee = employeeRepository.findById(emp_id)
//				.orElseThrow(() -> new ResourceNotFoundException("Employee " + emp_id + " not found."));
//		
//		employeeRepository.delete(employee);
//		Map<String, Boolean> response = new HashMap<>();
//		response.put(employee.getEmp_id()+" is deleted", true);
//		return ResponseEntity.ok(response);
//	}
	
}