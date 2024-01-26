import { Component, OnInit } from '@angular/core';
import { Order } from '../order';
import { OrderService } from '../order.service';
import { ActivatedRoute, Router } from '@angular/router';
import { tick } from '@angular/core/testing';

@Component({
  selector: 'app-update-order',
  templateUrl: './update-order.component.html',
  styleUrls: ['./update-order.component.css']
})
export class UpdateOrderComponent implements OnInit
{
  orderId!:number;
  order:Order=new Order();
  constructor(private orderService:OrderService,private router:Router,private route:ActivatedRoute){}

  ngOnInit(): void 
  {
    this.order=new Order();
    this.orderId=this.route.snapshot.params['orderId'];
    this.orderService.getOrderById(this.orderId).subscribe(data=>
      {this.order=data;},
      error=>console.log(error));
  }

  onSubmit()
  {
    this.updateOrder();
  }
  updateOrder() 
  {
    this.orderService.updateOrder(this.orderId,this.order).subscribe(data=>
      {
        this.gotoOrderList()
      });
  }
  gotoOrderList() 
  {
    this.router.navigate(['/orders']);
  }

}
