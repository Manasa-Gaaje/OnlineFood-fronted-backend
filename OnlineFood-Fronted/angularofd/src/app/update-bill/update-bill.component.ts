import { Component, OnInit } from '@angular/core';
import { Bill } from '../bill';
import { BillService } from '../bill.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-bill',
  templateUrl: './update-bill.component.html',
  styleUrls: ['./update-bill.component.css']
})
export class UpdateBillComponent implements OnInit 
{
  billId!:number;

  bill:Bill=new Bill();

  constructor(private billService:BillService,private router:Router,private route:ActivatedRoute){}

  ngOnInit(): void 
  {
    this.bill=new Bill();
    this.billId=this.route.snapshot.params['billId'];
    this.billService.getBillById(this.billId).subscribe(data=>
      {this.bill=data;},
      error=>console.log(error));
   
  }

  onSubmit()
  {
    this.updateBill();
  }

  updateBill() 
  {
    this.billService.updateBill(this.billId,this.bill).subscribe(data=>
      {
        this.gotoBillList()
      });
  }

  gotoBillList() 
  {
    this.router.navigate(['/bills']);
  }

}
