package com.appfood.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.appfood.model.Bill;
import com.appfood.model.Order;
import com.appfood.repository.BillJpaRepository;
import com.appfood.repository.BillRepository;
import com.appfood.repository.OrderJpaRepository;

import jakarta.persistence.EntityManager;


@Service
public class BillJpaService implements BillRepository 
{
	@Autowired
	private BillJpaRepository billJpaRepository;
	
	@Autowired
	private OrderJpaRepository orderJpaRepository;
	
	
	//@Autowired
   // private EntityManager entityManager;

	
	
	@Autowired
	private OrderJpaService orderJpaService;
	
	@Override
	public ArrayList<Bill> getBill() 
	{
		List<Bill> billList=billJpaRepository.findAll();
		ArrayList<Bill> bills=new ArrayList<>(billList);
		return bills;
	}

	@Override
	public Bill getBillById(int billId) 
	{
		try
		{
			Bill bill=billJpaRepository.findById(billId).get();
			return bill;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@Override
	public Bill addBill(Bill bill) 
	{
		//Order order=bill.getOrder();
		//Order existingOrder=orderJpaRepository.
		//orderJpaService.updateOrder(order.getOrderId(),bill.getOrder());
		//billJpaRepository.save(bill);
	     // return bill;
		//Order order=orderJpaRepository.findById(orderId).get();
	
		//Order order=bill.getOrder();
		//int orderId=order.getOrderId();
		//Order order1=orderJpaRepository.findById(orderId).get();
		//bill.setOrder(order1);
		billJpaRepository.save(bill);
		return bill; 

		//Order order = bill.getOrder();	    
	    //if (order != null) 
	   // {
	        
	      // orderJpaRepository.save(order);
	        //bill.setOrder(order);
	      //  billJpaRepository.save(bill);

	         
	    //}
		
		
		
		
		
	}
	

	@Override
	public Bill updateBill(int billId, Bill bill) 
	{
		try
		{
			Bill existingBill=billJpaRepository.findById(billId).get();

			if(bill.getBillDate()!=null)
			{
				existingBill.setBillDate(bill.getBillDate());
			}
			
			if(bill.getTotalItem()!=0)
			{
				existingBill.setTotalItem(bill.getTotalItem());
			}
			
			return billJpaRepository.save(existingBill);
			
			
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}
		

	@Override
	public void deleteBill(int billId) 
	{
		try
		{
			Bill bill=billJpaRepository.findById(billId).get();
			if(bill!=null)
			{
				billJpaRepository.deleteById(billId);
			}
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	
}
