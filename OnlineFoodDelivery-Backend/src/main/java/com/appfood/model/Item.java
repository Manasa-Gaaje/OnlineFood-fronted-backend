package com.appfood.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Item")
public class Item 
{
  @Id
  //@GeneratedValue(strategy=GenerationType.IDENTITY)
  
  @Column(name="itemId")
  private int itemId;
  
  @Column(name="itemName")
  private String itemName;
  
  @Column(name="quantity")
   private int quantity;
  
  @ManyToOne
  @JoinColumn(name = "restaurantId")
  private Restaurant restaurant;

public int getItemId() {
	return itemId;
}

public void setItemId(int itemId) {
	this.itemId = itemId;
}

public String getItemName() {
	return itemName;
}

public void setItemName(String itemName) {
	this.itemName = itemName;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public Restaurant getRestaurant() {
	return restaurant;
}

public void setRestaurant(Restaurant restaurant) {
	this.restaurant = restaurant;
}

public Item(int itemId, String itemName, int quantity, Restaurant restaurant) {
	super();
	this.itemId = itemId;
	this.itemName = itemName;
	this.quantity = quantity;
	this.restaurant = restaurant;
}

public Item() {
	super();
	// TODO Auto-generated constructor stub
}
  




  
  


  
  
  
  
  
  

}