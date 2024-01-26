import { Component, OnInit } from '@angular/core';
import { Item } from '../item';
import { ItemService } from '../item.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-item',
  templateUrl: './update-item.component.html',
  styleUrls: ['./update-item.component.css']
})
export class UpdateItemComponent implements OnInit 
{
  itemId!:number;

  item:Item=new Item();

  constructor(private itemService:ItemService,private router:Router,private route:ActivatedRoute){}

  ngOnInit(): void 
  {
    this.item=new Item();
    this.itemId=this.route.snapshot.params['itemId'];
    this.itemService.getItemById(this.itemId).subscribe(data=>
      {this.item=data;},
      error=>console.log(error));
      
  }

  onSubmit()
  {
    this.updateItem();
  }

  updateItem() 
  {
    this.itemService.updateItem(this.itemId,this.item).subscribe(data=>
      {
        this.gotoItemList()
      });
  }

  gotoItemList() 
  {
    this.router.navigate(['/items']);
  }

}
