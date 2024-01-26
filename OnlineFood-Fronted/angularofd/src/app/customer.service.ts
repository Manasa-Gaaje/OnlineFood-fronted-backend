import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from './customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService 
{
  private baseUrl="http://localhost:8080/customers";
  private baseUrl1="http://localhost:8080/customers/addnewcustomer";


  constructor(private httpClient:HttpClient) { }

  getCustomers():Observable<Customer[]>
  {
     return this.httpClient.get<Customer[]>(`${this.baseUrl}`);
  }

  getCustomerById(customerId:number):Observable<Customer>
  {
   return this.httpClient.get<Customer>(`${this.baseUrl}/${customerId}`);

  }

  createCustomer(customer:Customer):Observable<Object>
  {
      return this.httpClient.post(`${this.baseUrl1}`,customer);
  }

  updateCustomer(customerId:number,customer:Customer):Observable<Object>
  {
     return this.httpClient.put(`${this.baseUrl}/${customerId}`,customer);
  }

  deleteCustomer(customerId:number):Observable<any>
  {
     return this.httpClient.delete(`${this.baseUrl}/${customerId}`);
  }

  
  
}
