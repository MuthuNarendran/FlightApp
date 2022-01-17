import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { BookingData } from '../model/bookingData';
import { FlightBookingService } from '../services/flight-booking.service';
import { SharedService } from '../services/shared-services';

@Component({
  selector: 'app-passenger',
  templateUrl: './passenger.component.html',
  styleUrls: ['./passenger.component.css']
})

export class PassengerComponent implements OnInit {
  @ViewChild('postPassengerForm') private postPassengerForm!: NgForm;
  id!: number;
  message: string = "";
  bookingFormData: any
  bookingData!: BookingData;
  passengerForm!: FormGroup;
  passengerArray: any[] = []
  disabled: string = "false";
  numberofpassenger = this._Activatedroute.snapshot.paramMap.get("numberofpassenger");
  count: number = Number(this.numberofpassenger);
  passangerArr!: any;
  constructor(private sharedService: SharedService, private flightBookingService: FlightBookingService, private _Activatedroute: ActivatedRoute, private router: Router, private fb: FormBuilder) { }
  ngOnInit(): void {
    console.log("ji")
    this.addPassengerBtnStatus();
    this.count--;
    this.passengerForm = this.fb.group({
      passengers: this.fb.array([this.createPassenger()])
    })
  }

  createPassenger(): FormGroup {
    return this.fb.group({
      name: '',
      gender: ''
    })
  }

  get passengers() {
    return this.passengerForm.get('passengers') as FormArray;
  }

  addPassengerBtnStatus() {
    if (this.count <= 1) {
      const addPassengerBtn: Element = document.querySelector('.addNewPassenger')!;
      addPassengerBtn.setAttribute('style', 'display:none;');
    }
  }

  addNewPassenger() {
    this.passengers.push(this.createPassenger());
    this.addPassengerBtnStatus();
    this.count--;
  }

  onSubmit() {
    console.log(this.passengerForm)
    this.bookingFormData = this.sharedService.getBookingData();
    this.id = this.sharedService.getId();
    this.passengerArray = [];
    this.passengers.controls.forEach(control => {
      this.passengerArray.push(control.value);
    })

    this.passangerArr = this.passengerArray.map(passenger => ({ name: passenger.name, gender: passenger.gender }));
    this.bookingData = new BookingData(this.bookingFormData.name, this.bookingFormData.emailid,
      this.bookingFormData.economyseats, this.bookingFormData.businessseats, this.passangerArr,
      this.bookingFormData.economyseatnumbers.split(","), this.bookingFormData.businessseatnumbers.split(","));
    console.log(this.bookingData)
    this.flightBookingService.bookFlights(this.bookingData, this.id).subscribe((res: any) => {
      console.log(res);
      this.message = "Your Tickets are booked and the PNR is " + res.pnr;
    });
    this.postPassengerForm.resetForm();
  }

}
