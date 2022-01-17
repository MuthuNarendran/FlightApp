import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, NgForm } from '@angular/forms';
import { Airline } from '../../model/airline';
import { Flight } from '../../model/flight';
import { AddFlightService } from '../../services/add-flight.service';

@Component({
  selector: 'app-add-flight',
  templateUrl: './add-flight.component.html',
  styleUrls: ['./add-flight.component.css']
})
export class AddFlightComponent implements OnInit {
  airlineObj!:Airline;
  flightObj!: Flight;
  businessClassSeatNumbers:string[]=[];
  economyClassSeatNumbers:string[]=[];
  @ViewChild('postForm') private postForm!: NgForm;
  message!: string;
  err: boolean=false;
  constructor(private formBuilder: FormBuilder, private flightService: AddFlightService) {
  }

  ngOnInit(): void {
  }

  onSubmit(data: any) {
    this.airlineObj = new Airline(data.airlinename);
    this.businessClassSeatNumbers = data.businessClassSeatNumbers.split(",");
    this.economyClassSeatNumbers = data.economyClassSeatNumbers.split(",");
    const formattedDate = ("0" + data.date.getDate()).slice(-2)+"-"+("0"+(data.date.getMonth()+1)).slice(-2)+"-"+ data.date.getFullYear();
    this.flightObj = new Flight(data.number,this.airlineObj,data.origin,data.destination,formattedDate,
      data.startTime,data.endTime,data.days,data.businessClassSeats,data.economyClassSeats,
      this.businessClassSeatNumbers,this.economyClassSeatNumbers,data.meals,data.fare);
    this.flightService.saveFlights(this.flightObj).subscribe((res: any) => {
      const message = "The Flight With Number " + data.number +" is added successfully";
      this.errorMessage(message);
    },
    error => {
      this.err=true;
      this.errorMessage(error.error.message);
    })
    this.postForm.resetForm();
  }

  errorMessage(message:any){
   this.message= message;
   console.log(this.err);
   if(this.err) {
     const node = document.querySelector('.submitmsg')
     node?.setAttribute('class','errorsubmitmsg');
   }
  }
}
