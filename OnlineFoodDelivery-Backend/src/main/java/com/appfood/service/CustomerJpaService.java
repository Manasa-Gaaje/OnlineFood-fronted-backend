package com.appfood.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.appfood.model.Customer;
import com.appfood.repository.CustomerJpaRepository;
import com.appfood.repository.CustomerRepository;

@Service
public class CustomerJpaService implements CustomerRepository 
{
	
	@Autowired
	   private CustomerJpaRepository customerJpaRepository;
	   
	   
	   @Override
		public ArrayList<Customer> getCustomer() 
		{
			List<Customer> customerList=customerJpaRepository.findAll();
			ArrayList<Customer> customers=new ArrayList<>(customerList);
			return customers;
		}

		@Override
		public Customer getCustomerById(int customerId) 
		{
			try
			{
				Customer customer=customerJpaRepository.findById(customerId).get();
				return customer;
			}
			catch(Exception e)
			{
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}
			
		}
		
		@Override
		public Customer addCustomer(Customer customer) 
		{
			customerJpaRepository.save(customer);
		      return customer;
		}

		@Override
		public Customer updateCustomer(int customerId, Customer customer) 
		{
			try
			{
				Customer existingCustomer=customerJpaRepository.findById(customerId).get();
				
				if(customer.getFullName()!=null)
				{
					existingCustomer.setFullName(customer.getFullName());
				}
				if(customer.getAge()!=0)
				{
					existingCustomer.setAge(customer.getAge());
				}
				if(customer.getEmail()!=null)
				{
					existingCustomer.setEmail(customer.getEmail());
				}
				if(customer.getPassword()!=null)
				{
					existingCustomer.setPassword(customer.getPassword());
				}
				
				return customerJpaRepository.save(existingCustomer);
				
			}
			catch(Exception e)
			{
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}	
		}

		@Override
		public void deleteCustomer(int customerId) 
		{
			try
			{
				Customer customer=customerJpaRepository.findById(customerId).get();
				if(customer!=null)
				{
					customerJpaRepository.deleteById(customerId);
				}
			}
			catch(Exception e)
			{
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}
		}

}
