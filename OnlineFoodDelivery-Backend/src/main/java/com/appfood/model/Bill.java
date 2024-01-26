package com.appfood.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="bill")
public class Bill 
{
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	
	@Column(name="billId")
	private int billId;
	
	
	@Column(name="billDate")
	private Date billDate;
	
	
	@Column(name="totalItem")
	private int totalItem;
	
	//@OneToOne(cascade=CascadeType.ALL)
		//@JoinColumn(name="orderId")
		//private Order order;



	public int getBillId() {
		return billId;
	}


	public void setBillId(int billId) {
		this.billId = billId;
	}


	public Date getBillDate() {
		return billDate;
	}


	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}


	public int getTotalItem() {
		return totalItem;
	}


	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
	}


	public Bill(int billId, Date billDate, int totalItem) {
		super();
		this.billId = billId;
		this.billDate = billDate;
		this.totalItem = totalItem;
	}


	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	}