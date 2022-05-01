
package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="recipe")

public class Recipe {
	
    @Id private String Boba_id;
	@Column(name ="Ingredient_id") private Integer Ingredient_id;
	@Column(name="store_id") private String store_id;	
	
//	@OneToOne
//	@JoinColumn(foreignKey = @ForeignKey(name="boba_id", foreignKeyDefinition = "foreign key /* FK */ (boba_id) references Boba"))
//	public Boba boba;
//	
//	@ManyToOne
//	@JoinColumn(foreignKey = @ForeignKey(name="store_id", foreignKeyDefinition = "foreign key /* FK */ (store_id) references Store"))
//	public Store store;


	public Recipe () {}
	
	public Recipe (String store_id, String Boba_id, Integer Ingredient_id) {
		this.store_id = store_id;
        this.Boba_id = Boba_id;
		this.Ingredient_id = Ingredient_id;
	}
	
	public String getStore_id() {
		return store_id;
	}
    public String getBoba_id() {
		return Boba_id;
	}
    public Integer getIngredientId() {
		return Ingredient_id;
	}


    public void setStore_id(String store_id) {
		this.store_id = store_id;
	}
	public void setBoba_id(String Boba_id) {
		this.Boba_id = Boba_id;
	}
    public void setIngredient_id(Integer Ingredient_id) {
		this.Ingredient_id = Ingredient_id;
	}

	
	
}
