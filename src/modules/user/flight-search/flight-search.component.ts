import { SelectionModel } from '@angular/cdk/collections';
import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Airline } from 'src/modules/admin/model/airline';
import { UserSearch } from '../model/userSearch';
import { FlightBookingService } from '../services/flight-booking.service';

@Component({
  selector: 'app-flight-search',
  templateUrl: './flight-search.component.html',
  styleUrls: ['./flight-search.component.css']
})
export class FlightSearchComponent implements OnInit {
  displayedColumns! : string[];
  ELEMENT_DATA: FlightSearchData[] = []
  userSearchData!: UserSearch;
  dataSource :any;
  selection: any;

  constructor(private flightBookingService:FlightBookingService,private router:Router) {}
  @ViewChild('postForm') private postForm!: NgForm;
  ngOnInit(): void {}

  onSubmit(data:any) {
    let formattedRetDate="";
    const formattedDestDate =  ("0" + data.depaturedate.getDate()).slice(-2)+"-"+("0"+(data.depaturedate.getMonth()+1)).slice(-2)+"-"+ data.depaturedate.getFullYear();
    if(data.returndate){
      formattedRetDate = ("0" + data.returndate.getDate()).slice(-2)+"-"+("0"+(data.returndate.getMonth()+1)).slice(-2)+"-"+ data.returndate.getFullYear();
    }

    this.userSearchData = new UserSearch(formattedDestDate,data.destination,formattedRetDate,data.source);
    console.log(this.userSearchData)
    this.flightBookingService.searchFlights(this.userSearchData).subscribe((res: any) => {
    this.ELEMENT_DATA = res as FlightSearchData[];
    console.log(this.ELEMENT_DATA as FlightSearchData[]);
    this.displayedColumns = ['airline','origin','destination','date','startTime',
    'endTime','actions'];
    this.dataSource = this.ELEMENT_DATA;
    },
    error => {
     console.log(error);
    })
    this.postForm.resetForm();
  }  

  onBook(id:any){
    console.log(id)
    this.router.navigate(["/", "user", "homepage","book",id])
  }

}

export interface FlightSearchData {
  id:number;
  number: number;
  airline: Airline;
  origin: string;
  destination: string;
  date: string;
  startTime: string;
  endTime: string;
  scheduledDays: string;
  businessSeats: number;
  economySeats: number;
  businessClassSeatNumber: string[];
  economyClassSeatNumber: string[]
  fare: number;
  meals: string;
}





