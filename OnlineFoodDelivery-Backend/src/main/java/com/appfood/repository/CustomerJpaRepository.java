package com.appfood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.appfood.model.Customer;

public interface CustomerJpaRepository extends JpaRepository<Customer,Integer> 
{

	Customer findByEmail(String email);

	

}
