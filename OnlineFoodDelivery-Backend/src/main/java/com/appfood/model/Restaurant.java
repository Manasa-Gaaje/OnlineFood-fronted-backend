package com.appfood.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="restaurant")
public class Restaurant 
{
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	
    @Column(name="restaurantId")
	private int restaurantId;
	
	@Column(name="restaurantName")
	private String restaurantName;
	
	@Column(name="managerName")
	private String managerName;
	
	@Column(name="contactNumber")
	private Long contactNumber;
	
	@OneToMany(targetEntity=Item.class,cascade=CascadeType.ALL)
	private List<Item> itemList=new ArrayList<>();


	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public Restaurant(int restaurantId, String restaurantName, String managerName, Long contactNumber,
			List<Item> itemList) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.managerName = managerName;
		this.contactNumber = contactNumber;
		this.itemList = itemList;
	}

	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	
	
	
	
	
	
	
	
}
