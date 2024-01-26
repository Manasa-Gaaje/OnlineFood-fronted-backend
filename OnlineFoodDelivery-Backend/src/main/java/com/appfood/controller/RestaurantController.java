package com.appfood.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.appfood.model.Restaurant;
import com.appfood.service.RestaurantJpaService;


@RestController
@CrossOrigin
public class RestaurantController 
{
	@Autowired
	private RestaurantJpaService restaurantService;
	
	
	@GetMapping("/restaurants")
	public ArrayList<Restaurant> getRestaurants()
	{
		return restaurantService.getRestaurant();
	}
	
	@GetMapping("/restaurants/{restaurantId}")
	public Restaurant getRestaurantId(@PathVariable int restaurantId)
	{
		return restaurantService.getRestaurantById(restaurantId);
	}
	
	@PostMapping("/restaurants/addnewrestaurant")
	public Restaurant addRestaurant(@RequestBody Restaurant restaurant)
	{
		return restaurantService.addRestaurant(restaurant);
	}
	
	@PutMapping("/restaurants/{restaurantId}")
	public Restaurant updateRestaurant(@PathVariable int restaurantId,@RequestBody Restaurant restaurant)
	{
		return restaurantService.updateRestaurant(restaurantId,restaurant);
	}
	
	@DeleteMapping("/restaurants/{restaurantId}")
	public void deleteRestaurant(@PathVariable int restaurantId)
	{
		restaurantService.deleteRestaurant(restaurantId);
	}
	

}
