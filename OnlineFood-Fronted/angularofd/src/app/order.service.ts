import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from './order';

@Injectable({
  providedIn: 'root'
})
export class OrderService 
{
  private baseUrl="http://localhost:8080/orders";
  private baseUrl1="http://localhost:8080/orders/addneworder";
 

  constructor(private httpClient:HttpClient) { }

  getOrders():Observable<Order[]>
  {
     return this.httpClient.get<Order[]>(`${this.baseUrl}`);
  }

  getOrderById(orderId:number):Observable<Order>
  {
    return this.httpClient.get<Order>(`${this.baseUrl}/${orderId}`);
  }

  createOrder(order:Order):Observable<Object>
  {
      return this.httpClient.post(`${this.baseUrl1}`,order);
  }

  updateOrder(orderId:number,order:Order):Observable<Object>
  {
     return this.httpClient.put(`${this.baseUrl}/${orderId}`,order);
  }

  deleteOrder(orderId:number):Observable<any>
  {
     return this.httpClient.delete(`${this.baseUrl}/${orderId}`);
  }
}
