
package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="recipe")

public class Recipe {
	
    @Id private Integer Store_id;
    @Id private Integer Boba_id;
	@Column(name ="Ingredient_id") private Integer Ingredient_id;
	@Column(name="iquantity") private Integer iquantity;	


	public Recipe () {}
	
	public Recipe (Integer Store_id, Integer Boba_id, Integer Ingredient_id, Integer iquantity) {
		this.Store_id = Store_id;
        this.Boba_id = Boba_id;
		this.Ingredient_id = Ingredient_id;
		this.iquantity = iquantity;
	}
	
	public Integer getStore_id() {
		return Store_id;
	}
    public Integer getBoba_id() {
		return Boba_id;
	}
    public Integer getIngredientId() {
		return Ingredient_id;
	}
    public Integer getQuantity() {
		return iquantity;
	}


    public void setStore_id(Integer Store_id) {
		this.Store_id = Store_id;
	}
	public void setBoba_id(Integer Boba_id) {
		this.Boba_id = Boba_id;
	}
    public void setIngredient_id(Integer Ingredient_id) {
		this.Ingredient_id = Ingredient_id;
	}
    public void setQuantity(Integer iquantity) {
		this.iquantity = iquantity;
	}



	
	
}
