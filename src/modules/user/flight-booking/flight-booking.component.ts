import { SelectionModel } from '@angular/cdk/collections';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Airline } from 'src/modules/admin/model/airline';
import { BookingData } from '../model/bookingData';
import { UserSearch } from '../model/userSearch';
import { FlightBookingService } from '../services/flight-booking.service';
import { ActivatedRoute, Router } from '@angular/router';
import { SharedService } from '../services/shared-services';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-flight-booking',
  templateUrl: './flight-booking.component.html',
  styleUrls: ['./flight-booking.component.css']
})
export class FlightBookingComponent implements OnInit {
  totalSeats:number=1;

  constructor(private _Activatedroute:ActivatedRoute,private router:Router,private sharedService:SharedService){}
  id=this._Activatedroute.snapshot.paramMap.get("id");
  ngOnInit(): void {}

  onNext(data:any){
   this.sharedService.setBookingData(data);
   this.sharedService.setId(Number(this.id));
   this.totalSeats = Number(data.businessseats) + Number(data.economyseats);
   this.router.navigate(["/", "user", "homepage","addpassenger",this.totalSeats])
  }

 

}
