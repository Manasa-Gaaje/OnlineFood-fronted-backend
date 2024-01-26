import { Component, OnInit } from '@angular/core';
import { Restaurant } from '../restaurant';
import { RestaurantService } from '../restaurant.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-restaurant',
  templateUrl: './update-restaurant.component.html',
  styleUrls: ['./update-restaurant.component.css']
})
export class UpdateRestaurantComponent implements OnInit
{
  restaurantId!:number;
  restaurant:Restaurant=new Restaurant();
  constructor(private restaurantService:RestaurantService,private router:Router,private route:ActivatedRoute){}

  ngOnInit(): void 
  {
    this.restaurant=new Restaurant();
    this.restaurantId=this.route.snapshot.params['restaurantId'];
    this.restaurantService.getRestaurantById(this.restaurantId).subscribe(data=>
      {this.restaurant=data;},
      error=>console.log(error));
  }

  onSubmit()
  {
    this.updateRestaurant();
  }

  updateRestaurant() 
  {
    this.restaurantService.updateRestaurant(this.restaurantId,this.restaurant).subscribe(data=>
      {
        this.gotoRestaurantList()
      });
  }
  gotoRestaurantList() 
  {
    this.router.navigate(['/restaurants']);
  }
 

}
