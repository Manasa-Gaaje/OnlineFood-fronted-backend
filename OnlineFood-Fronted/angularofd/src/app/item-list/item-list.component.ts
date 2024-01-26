import { Component, OnInit } from '@angular/core';
import { ItemService } from '../item.service';
import { Router } from '@angular/router';
import { Item } from '../item';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit
{
  constructor(private itemService:ItemService,private router:Router){}

  items:Item[]=[];

  ngOnInit(): void 
  {
    this.getItems();
  }

  getItems() 
  {
    this.itemService.getItems().subscribe(data=>
      {
        this.items=data;
      });
  }

  updateItem(itemId:number)
  {
    this.router.navigate(['items',itemId]);
  }

  deleteItem(itemId:number):void
  {
    this.itemService.deleteItem(itemId).subscribe(
      data=>
      {
        console.log(data);
        this.getItems();
      }
    )
  }

}
