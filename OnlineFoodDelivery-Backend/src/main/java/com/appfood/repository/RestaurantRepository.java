package com.appfood.repository;

import java.util.ArrayList;
import com.appfood.model.Restaurant;

public interface RestaurantRepository 
{
	
	ArrayList<Restaurant> getRestaurant();
	Restaurant getRestaurantById(int restaurantId);
	Restaurant addRestaurant(Restaurant restaurant);
	Restaurant updateRestaurant(int restaurantId, Restaurant restaurant);
	void deleteRestaurant(int restaurantId);


}
