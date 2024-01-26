package com.appfood.repository;

import java.util.ArrayList;
import com.appfood.model.Customer;


public interface CustomerRepository 
{
	ArrayList<Customer> getCustomer();
	Customer getCustomerById(int customerId);
	Customer addCustomer(Customer customer);
	Customer updateCustomer(int customerId,Customer customer);
	void deleteCustomer(int customerId);

}
