import { Component, OnInit } from '@angular/core';
import { RestaurantService } from '../restaurant.service';
import { Router } from '@angular/router';
import { Restaurant } from '../restaurant';

@Component({
  selector: 'app-restaurant-list',
  templateUrl: './restaurant-list.component.html',
  styleUrls: ['./restaurant-list.component.css']
})
export class RestaurantListComponent implements OnInit
{
  constructor(private restaurantService:RestaurantService,private router:Router){}
  
  restaurants:Restaurant[]=[];

  ngOnInit(): void 
  {
    this.getRestaurants();
  }

  private getRestaurants() 
  {
    this.restaurantService.getRestaurants().subscribe(data=>
      {
        this.restaurants=data;
      });
  }

  updateRestaurant(restaurantId:number)
  {
    this.router.navigate(['restaurants',restaurantId]);
  }

  deleteRestaurant(restaurantId:number):void
  {
    this.restaurantService.deleteRestaurant(restaurantId).subscribe(
      data=>
      {
        console.log(data);
        this.getRestaurants();
      }
    )
  }

}
