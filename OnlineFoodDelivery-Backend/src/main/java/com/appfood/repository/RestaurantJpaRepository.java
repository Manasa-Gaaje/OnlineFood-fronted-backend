package com.appfood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.appfood.model.Restaurant;

public interface RestaurantJpaRepository extends JpaRepository<Restaurant, Integer> 
{

}
