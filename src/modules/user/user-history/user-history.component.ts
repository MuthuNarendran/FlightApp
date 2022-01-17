import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Passenger } from '../model/passenger';
import { FlightBookingService } from '../services/flight-booking.service';

@Component({
  selector: 'app-user-history',
  templateUrl: './user-history.component.html',
  styleUrls: ['./user-history.component.css']
})
export class UserHistoryComponent implements OnInit {
  ELEMENT_DATA: any;
  displayedColumns!: string[];
  dataSource: any;
  selection: any;

  constructor(private flightBookingService:FlightBookingService) { }
  @ViewChild('postForm') private postForm!: NgForm;
  ngOnInit(): void {
  }

  onSubmit(data:any) {
    this.flightBookingService.searchTicketsByUserHistory(data.emailid).subscribe((res: any) => {
      console.log(res)
    this.ELEMENT_DATA = res as UserHistoryData[];
    console.log(this.ELEMENT_DATA as UserHistoryData[]);
    this.displayedColumns = ['name','airlineName','depatureTime','endTime','date',
    'source','destination','businessSeat','economySeat'];
    this.dataSource = this.ELEMENT_DATA;
    });
    this.postForm.resetForm();
  } 
}

export interface UserHistoryData {
  pnr:number;
  name: string;
  flightId:number;
  airlineName: string;
  depatureTime: string;
  endTime: string;
  date: string;
  source: string;
  destination: string;
  businessSeat: number;
  economySeat: number;
  emailId:string
  businessClassSeatNumber: string[];
  economyClassSeatNumber: string[]
  passenger: Passenger[];
}
