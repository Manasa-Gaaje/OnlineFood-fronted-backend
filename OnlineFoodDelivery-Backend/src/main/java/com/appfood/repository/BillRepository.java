package com.appfood.repository;

import java.util.ArrayList;
import com.appfood.model.Bill;


public interface BillRepository 
{
	ArrayList<Bill> getBill();
	Bill getBillById(int billId);
	Bill addBill(Bill bill);
	Bill updateBill(int billId,Bill bill);
	void deleteBill(int billId);

}
