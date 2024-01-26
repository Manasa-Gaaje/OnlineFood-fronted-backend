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

import com.appfood.model.Order;
import com.appfood.service.OrderJpaService;


@RestController
@CrossOrigin
public class OrderController 
{
	
	@Autowired
	private OrderJpaService orderService;
	
	@GetMapping("/orders")
	public ArrayList<Order> getOrders()
	{
		return orderService.getOrder();
	}
	
	@GetMapping("/orders/{orderId}")
	public Order getOrderId(@PathVariable int orderId)
	{
		return orderService.getOrderById(orderId);
	}
	
	@PostMapping("/orders/addneworder")
	public Order addOrder(@RequestBody Order order)
	{
		return orderService.addOrder(order);
	}
	
	@PutMapping("/orders/{orderId}")
	public Order updateOrder(@PathVariable int orderId,@RequestBody Order order)
	{
		return orderService.updateOrder(orderId,order);
	}
	
	@DeleteMapping("/orders/{orderId}")
	public void deleteOrder(@PathVariable int orderId)
	{
		orderService.deleteOrder(orderId);
	}
	
	

}
