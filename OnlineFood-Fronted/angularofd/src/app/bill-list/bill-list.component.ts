import { Component, OnInit } from '@angular/core';
import { BillService } from '../bill.service';
import { Router } from '@angular/router';
import { Bill } from '../bill';

@Component({
  selector: 'app-bill-list',
  templateUrl: './bill-list.component.html',
  styleUrls: ['./bill-list.component.css']
})
export class BillListComponent implements OnInit
{
  constructor(private billService:BillService,private router:Router){}

  bills:Bill[]=[];

  ngOnInit(): void 
  {
    this.getBills();
  }

  private getBills() 
  {
    this.billService.getBills().subscribe(data=>
      {
        this.bills=data;
      })
  }

  updateBill(billId:number)
  {
    this.router.navigate(['/bills',billId]);
  }

  deleteBill(billId:number):void
  {
     this.billService.deleteBill(billId).subscribe(
      data=>
      {
        console.log(data);
        this.getBills();
      }
     )
  }

}
