package com.appfood.repository;

import java.util.ArrayList;
import com.appfood.model.Order;

public interface OrderRepository 
{
	ArrayList<Order> getOrder();
	Order getOrderById(int orderId);
	Order addOrder(Order order);
	Order updateOrder(int orderId, Order order);
	void deleteOrder(int orderId);

}
