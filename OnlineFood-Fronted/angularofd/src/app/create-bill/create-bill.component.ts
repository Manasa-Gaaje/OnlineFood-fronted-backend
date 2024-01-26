import { Component, OnInit } from '@angular/core';
import { Bill } from '../bill';
import { BillService } from '../bill.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-bill',
  templateUrl: './create-bill.component.html',
  styleUrls: ['./create-bill.component.css']
})
export class CreateBillComponent implements OnInit 
{
  bill:Bill=new Bill();

  constructor(private billService:BillService,private router:Router){}

  ngOnInit(): void 
  {
     
  }

  saveBill()
  {
    this.billService.createBill(this.bill).
    subscribe(data=> {console.log(data);
    this.gotoBillList()},error=>console.log(error)
    );
  }


  gotoBillList() 
  {
    this.router.navigate(['/bills']);
  }

  onSubmit()
  {
    this.saveBill();
  }

}
