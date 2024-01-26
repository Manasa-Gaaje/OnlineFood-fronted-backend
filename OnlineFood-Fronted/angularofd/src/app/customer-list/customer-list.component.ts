import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { Router } from '@angular/router';
import { Customer } from '../customer';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit 
{
  constructor(private customerService:CustomerService,private router:Router){}
  customers:Customer[]=[];

    ngOnInit(): void 
    {
      this.getCustomers();
    }

  private getCustomers() 
  {
    this.customerService.getCustomers().subscribe(data=>
      {
        this.customers=data;
      });
      
  }

  updateCustomer(customerId:number)
  {
    this.router.navigate(['customers',customerId]);
  }

  deleteCustomer(customerId:number):void
  { 
    this.customerService.deleteCustomer(customerId).subscribe(data=>
      {
        console.log(data);
        this.getCustomers();
      })

    
  }

}
