import { SelectionModel } from '@angular/cdk/collections';
import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';
import { Booking } from '../model/Booking';
import { FlightBookingService } from '../services/flight-booking.service';

@Component({
  selector: 'app-ticket-search',
  templateUrl: './ticket-search.component.html',
  styleUrls: ['./ticket-search.component.css']
})
export class TicketSearchComponent implements OnInit {
 pnrNo!:number;
 booking!: Booking ;
 displayedColumns! : string[];
 dataSource :any;
 selection: any;
 constructor(private flightBookingService:FlightBookingService) {}
 @ViewChild('postForm') private postForm!: NgForm;
  ngOnInit(): void {}

  onSubmit(data:any) {
    this.pnrNo = data.pnr;
    this.flightBookingService.searchTicketsByPNR(this.pnrNo).subscribe((res: any) => {
    this.booking= res;
    console.log(this.booking);
    this.displayedColumns = ['pnr','name','airlineName','depatureTime','endTime',
    'date','source','destination','businessSeat','economySeat'];
    this.dataSource = new MatTableDataSource([this.booking]);
    this.postForm.resetForm();
    });
  } 

}