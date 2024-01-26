import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent implements OnInit 
{
  customerId!:number;
  customer:Customer=new Customer();
  constructor(private customerService:CustomerService,private router:Router,private route:ActivatedRoute){}

  ngOnInit(): void 
  {
    this.customer=new Customer();
    this.customerId=this.route.snapshot.params['customerId'];
    this.customerService.getCustomerById(this.customerId).subscribe(data=>
      {
        this.customer=data;
      },
      error=>console.log(error));
  }

  onSubmit()
  {
    this.updateCustomer();
  }
  updateCustomer() 
  {
    this.customerService.updateCustomer(this.customerId,this.customer).subscribe(data=>
      {this.gotoCustomerList()});
  }
  gotoCustomerList() 
  {
    this.router.navigate(['/customers']);  
  }
 

 


  

}
