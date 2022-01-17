import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, NgForm } from '@angular/forms';
import { Airline } from '../../model/airline';
import { AddAirlineService } from '../../services/add-airline.service';
import { SecurityServiceService } from '../../../../app/login/security-service.service';

@Component({
  selector: 'app-add-airline',
  templateUrl: './add-airline.component.html',
  styleUrls: ['./add-airline.component.css']
})
export class AddAirlineComponent implements OnInit {

  airline: Airline[] = [];
  airlineObj!: Airline;
  @ViewChild('postForm') private postForm!: NgForm;
  message!: string;

  constructor(private formBuilder: FormBuilder, private airlineService: AddAirlineService,) {
  }

  ngOnInit(): void {
  }

  onSubmit(data: any) {
    this.airlineObj = new Airline(data.airlineName, data.status);
    this.airlineService.saveAirline(this.airlineObj).subscribe((res: any) => {
    console.log(res);
    this.message = "The " + data.airlineName +" Airline is Added Successfully";
    })
    this.postForm.resetForm();
  }

}
