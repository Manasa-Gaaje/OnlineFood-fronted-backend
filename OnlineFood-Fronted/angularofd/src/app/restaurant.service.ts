import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Restaurant } from './restaurant';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService 
{
  private baseUrl="http://localhost:8080/restaurants";
  private baseUrl1="http://localhost:8080/restaurants/addnewrestaurant";

  constructor(private httpClient:HttpClient) { }

  getRestaurants():Observable<Restaurant[]>
  {
     return this.httpClient.get<Restaurant[]>(`${this.baseUrl}`);
  }

  getRestaurantById(restaurantId:number):Observable<Restaurant>
  {
     return this.httpClient.get<Restaurant>(`${this.baseUrl}/${restaurantId}`);
  }

  createRestaurant(restaurant:Restaurant):Observable<Object>
  {
      return this.httpClient.post(`${this.baseUrl1}`,restaurant);
  }

  updateRestaurant(restaurantId:number,restaurant:Restaurant):Observable<Object>
  {
     return this.httpClient.put(`${this.baseUrl}/${restaurantId}`,restaurant);
  }

  deleteRestaurant(restaurantId:number):Observable<any>
  {
     return this.httpClient.delete(`${this.baseUrl}/${restaurantId}`);
  }
}
