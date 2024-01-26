import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-userpanel',
  templateUrl: './userpanel.component.html',
  styleUrls: ['./userpanel.component.css']
})
export class UserpanelComponent implements OnInit 
{
  buttonFlag: any;
  admin: any;
  fullName: any;
  customer: any;
  
    constructor() { }
  
    ngOnInit(): void {
    }

}
