package com.appfood.model;

import java.util.Date;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Orderdetails")

public class Order 
{
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)

	@Column(name="orderId")
	private int orderId;
	
	@Column(name="orderDate")
	private Date orderDate;
	
	@Column(name="orderStatus")
	private String orderStatus;
	
	@OneToOne(cascade=CascadeType.ALL)
	//@JoinColumn(name="billId")
	private Bill bill;
	
	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Order(int orderId, Date orderDate, String orderStatus, Bill bill, Customer customer) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.bill = bill;
		this.customer = customer;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	}