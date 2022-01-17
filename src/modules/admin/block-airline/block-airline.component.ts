import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Airline } from '../model/airline';
import { AddAirlineService } from '../services/add-airline.service';

@Component({
  selector: 'app-block-airline',
  templateUrl: './block-airline.component.html',
  styleUrls: ['./block-airline.component.css']
})
export class BlockAirlineComponent implements OnInit {
  @ViewChild('postForm') private postForm!: NgForm;
  airline: Airline[] = [];
  airlineObj!: Airline;
  message!: string;

  constructor( private airlineService: AddAirlineService) { }

  ngOnInit(): void {
  }

  onSubmit(data: any) {
    this.airlineObj = new Airline(data.airlineName, data.status);
    this.airlineService.updateAirline(this.airlineObj).subscribe((res: any) => {
    console.log(res);
    this.message = "The " + data.airlineName +" Airline is blocked Now";
    })
    this.postForm.resetForm();
    
  }
}
