import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { Router } from '@angular/router';
import { Customer } from '../customer';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit
{
  customer:Customer=new Customer();
  
  
  constructor(private customerService:CustomerService,private router:Router){}

  ngOnInit(): void 
  {

  }

  saveCustomer()
  {
    this.customerService.createCustomer(this.customer).
    subscribe(data=> {console.log(data);
    this.gotoCustomerList()},error=>console.log(error)
    );
  }
  gotoCustomerList() 
  {
    this.router.navigate(['/customers']);
  }
  
  onSubmit()
  {
    this.saveCustomer();
  }

  

}
