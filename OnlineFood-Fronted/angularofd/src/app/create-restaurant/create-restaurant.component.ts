import { Component, OnInit } from '@angular/core';
import { Restaurant } from '../restaurant';
import { RestaurantService } from '../restaurant.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-restaurant',
  templateUrl: './create-restaurant.component.html',
  styleUrls: ['./create-restaurant.component.css']
})
export class CreateRestaurantComponent implements OnInit
{
  restaurant:Restaurant=new Restaurant();

  constructor(private restaurantService:RestaurantService,private router:Router){}

  ngOnInit(): void 
  {

  }
  saveRestaurant()
  {
    this.restaurantService.createRestaurant(this.restaurant).
    subscribe(data=> {console.log(data);
    this.gotoRestaurantList()},error=>console.log(error)
    );
    
  }
  gotoRestaurantList() 
  {
    this.router.navigate(['/restaurants']);
  }
  
  onSubmit()
  {
    this.saveRestaurant();
  }

}
