import { Component, OnInit } from '@angular/core';
import { OrderService } from '../order.service';
import { Router } from '@angular/router';
import { Order } from '../order';

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit
{
  constructor(private orderService:OrderService,private router:Router){}

  orders:Order[]=[];

  ngOnInit(): void 
  {
    this.getOrders();
  }

  getOrders() 
  {
    this.orderService.getOrders().subscribe(data=>
      {
        this.orders=data;
      });
  }

  updateOrder(orderId:number)
  {
    this.router.navigate(['orders',orderId]);

  }

  deleteOrder(orderId:number):void
  {
    this.orderService.deleteOrder(orderId).subscribe(data=>
      {
        console.log(data);
        this.getOrders();
      })
  }

}
