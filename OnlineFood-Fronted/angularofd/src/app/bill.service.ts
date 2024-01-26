import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Bill } from './bill';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BillService 
{
  private baseUrl="http://localhost:8080/bills";
  private baseUrl1="http://localhost:8080/bills/addnewbill";


  constructor(private httpClient:HttpClient) { }

  getBills():Observable<Bill[]>
  {
     return this.httpClient.get<Bill[]>(`${this.baseUrl}`);
  }

  getBillById(billId:number):Observable<Bill>
  {
    return this.httpClient.get<Bill>(`${this.baseUrl}/${billId}`)
  }

  createBill(bill:Bill):Observable<Object>
  {
      return this.httpClient.post(`${this.baseUrl1}`,bill);
  }

  updateBill(billId:number,bill:Bill):Observable<Object>
  {
     return this.httpClient.put(`${this.baseUrl}/${billId}`,bill);
  }

  deleteBill(billId:number):Observable<any>
  {
     return this.httpClient.delete(`${this.baseUrl}/${billId}`);
  }
}
