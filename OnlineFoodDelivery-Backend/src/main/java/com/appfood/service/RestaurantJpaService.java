package com.appfood.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.appfood.model.Restaurant;
import com.appfood.repository.RestaurantJpaRepository;
import com.appfood.repository.RestaurantRepository;

@Service
public class RestaurantJpaService implements RestaurantRepository
{
	
	@Autowired
    private RestaurantJpaRepository restaurantJpaRepository;

    
    @Override
   	public ArrayList<Restaurant> getRestaurant() 
   	{
   		List<Restaurant> restaurantList=restaurantJpaRepository.findAll();
   		ArrayList<Restaurant> restaurants=new ArrayList<>(restaurantList);
   		return restaurants;
   	}

   	@Override
   	public Restaurant getRestaurantById(int restaurantId) 
   	{
   		try
   		{
   			Restaurant restaurant=restaurantJpaRepository.findById(restaurantId).get();
   			return restaurant;
   		}
   		catch(Exception e)
   		{
   			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
   		}
   		
   	}
   	
   	@Override
   	public Restaurant addRestaurant(Restaurant restaurant) 
   	{
   		restaurantJpaRepository.save(restaurant);
   	      return restaurant;
   	}
   	

   	@Override
   	public Restaurant updateRestaurant(int restaurantId, Restaurant restaurant) 
   	{
   		try
   		{
   			Restaurant existingRestaurant=restaurantJpaRepository.findById(restaurantId).get();
   			if(restaurant.getRestaurantName()!=null)
   			{
   				existingRestaurant.setRestaurantName(restaurant.getRestaurantName());
   			}
   			
   			if(restaurant.getManagerName()!=null)
   			{
   				existingRestaurant.setManagerName(restaurant.getManagerName());
   			}
   			
   			if(restaurant.getContactNumber()!=0)
   			{
   				existingRestaurant.setContactNumber(restaurant.getContactNumber());
   			}
   			
            return restaurantJpaRepository.save(existingRestaurant);

   			
   			
   		}
   		catch(Exception e)
   		{
   			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
   		}	
   		
   	}

   	@Override
   	public void deleteRestaurant(int restaurantId) 
   	{
   		try
   		{
   			Restaurant restaurant=restaurantJpaRepository.findById(restaurantId).get();
   			if(restaurant!=null)
   			{
   				restaurantJpaRepository.deleteById(restaurantId);
   			}
   		}
   		catch(Exception e)
   		{
   			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
   		}
   	}

}
