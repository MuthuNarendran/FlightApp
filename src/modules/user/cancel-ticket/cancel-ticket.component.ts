import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { FlightBookingService } from '../services/flight-booking.service';

@Component({
  selector: 'app-cancel-ticket',
  templateUrl: './cancel-ticket.component.html',
  styleUrls: ['./cancel-ticket.component.css']
})
export class CancelTicketComponent implements OnInit {
  @ViewChild('postForm') private postForm!: NgForm;
  message!: string;
  constructor(private flightBookingService: FlightBookingService) { }

  ngOnInit(): void {
  }


  onSubmit(data: any) {
    this.flightBookingService.deleteTicketsByPnr(data.pnr).subscribe((res: any) => {
      console.log(res);
      this.message = "Your Tickets are cancelled for PNR No " + data.pnr;
    });
    this.postForm.resetForm();
  }

}
