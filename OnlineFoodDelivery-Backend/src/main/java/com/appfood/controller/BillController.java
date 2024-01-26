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
import com.appfood.model.Bill;
import com.appfood.service.BillJpaService;


@RestController
@CrossOrigin
public class BillController 
{
	@Autowired
	private BillJpaService billService;
	
	
	@GetMapping("/bills")
	public ArrayList<Bill> getBills()
	{
		return billService.getBill();
	}
	
	@GetMapping("/bills/{billId}")
	public Bill getBillId(@PathVariable int billId)
	{
		return billService.getBillById(billId);
	}
	
	@PostMapping("/bills/addnewbill")
	public Bill addBill(@RequestBody Bill bill)
	{
		return billService.addBill(bill);
	}
	
	@PutMapping("/bills/{billId}")
	public Bill updateBill(@PathVariable int billId,@RequestBody Bill bill)
	{
		return billService.updateBill(billId,bill);
	}
	
	@DeleteMapping("/bills/{billId}")
	public void deleteBill(@PathVariable int billId)
	{
		billService.deleteBill(billId);
	}
	

}
