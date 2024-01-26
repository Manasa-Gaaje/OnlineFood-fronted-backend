import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Item } from './item';

@Injectable({
  providedIn: 'root'
})
export class ItemService 
{
  private baseUrl="http://localhost:8080/items";
  private baseUrl1="http://localhost:8080/items/addnewitem";
 
  constructor(private httpClient:HttpClient) { }

  getItems():Observable<Item[]>
  {
     return this.httpClient.get<Item[]>(`${this.baseUrl}`);
  }

  getItemById(itemId:number):Observable<Item>
  {
     return this.httpClient.get<Item>(`${this.baseUrl}/${itemId}`);
  }

  createItem(item:Item):Observable<Object>
  {
      return this.httpClient.post(`${this.baseUrl1}`,item);
  }

  updateItem(itemId:number,item:Item):Observable<Object>
  {
     return this.httpClient.put(`${this.baseUrl}/${itemId}`,item);
  }

  deleteItem(itemId:number):Observable<any>
  {
     return this.httpClient.delete(`${this.baseUrl}/${itemId}`);
  }
}
