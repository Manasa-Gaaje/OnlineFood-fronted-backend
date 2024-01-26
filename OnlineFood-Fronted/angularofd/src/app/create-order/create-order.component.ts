import { Component, OnInit } from '@angular/core';
import { Order } from '../order';
import { OrderService } from '../order.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-order',
  templateUrl: './create-order.component.html',
  styleUrls: ['./create-order.component.css']
})
export class CreateOrderComponent implements OnInit 
{
  order:Order=new Order();
  constructor(private orderService:OrderService,private router:Router){}

  ngOnInit(): void 
  {

  }

  saveOrder()
  {
    this.orderService.createOrder(this.order).
    subscribe(data=> {console.log(data);
    this.gotoOrderList()},error=>console.log(error)
    );
  }
  gotoOrderList() 
  {
    this.router.navigate(['/orders']);
  }
 

  onSubmit()
  {
    this.saveOrder();
  }

}
