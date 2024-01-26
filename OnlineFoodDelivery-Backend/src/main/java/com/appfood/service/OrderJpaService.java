package com.appfood.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.appfood.model.Bill;
import com.appfood.model.Order;
import com.appfood.repository.BillJpaRepository;
import com.appfood.repository.OrderJpaRepository;
import com.appfood.repository.OrderRepository;

@Service
public class OrderJpaService implements OrderRepository 
{
	
	@Autowired
    private OrderJpaRepository orderJpaRepository;
	
	@Autowired
	private BillJpaRepository billJpaRepository;
	
	@Override
   	public ArrayList<Order> getOrder() 
   	{
   		List<Order> orderList=orderJpaRepository.findAll();
   		ArrayList<Order> orders=new ArrayList<>(orderList);
   		return orders;
   	}

   	@Override
   	public Order getOrderById(int orderId) 
   	{
   		try
   		{
   			Order order=orderJpaRepository.findById(orderId).get();
   			return order;
   		}
   		catch(Exception e)
   		{
   			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
   		}
   		
   	}
   	
   	@Override
   	public Order addOrder(Order order) 
   	{
   		
   		 orderJpaRepository.save(order);
   	     return order;
   		
   		
   	}
   	

   	@Override
   	public Order updateOrder(int orderId, Order order) 
   	{
   		try
   		{
   			Order existingOrder=orderJpaRepository.findById(orderId).get();
   			if(order.getOrderDate()!=null)
   			{
   				existingOrder.setOrderDate(order.getOrderDate());
   			}
   			if(order.getOrderStatus()!=null)
   			{
   				existingOrder.setOrderStatus(order.getOrderStatus());
   			}
   			
            return orderJpaRepository.save(existingOrder);

   			
   		}
   		catch(Exception e)
   		{
   			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
   		}	
   	}

   	@Override
   	public void deleteOrder(int orderId) 
   	{
   		try
   		{
   			Order order=orderJpaRepository.findById(orderId).get();
   			if(order!=null)
   			{
   				orderJpaRepository.deleteById(orderId);
   			}
   		}
   		catch(Exception e)
   		{
   			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
   		}
   	}
	

}
