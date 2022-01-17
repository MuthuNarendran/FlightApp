import { Component, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { ReactiveFormsModule } from "@angular/forms";
import { FormsModule } from '@angular/forms';
import {MatButtonModule} from '@angular/material/button';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatSliderModule} from '@angular/material/slider';
import {MatMenuModule} from '@angular/material/menu';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatCardModule} from '@angular/material/card';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatListModule} from '@angular/material/list';
import { HttpClientModule } from '@angular/common/http';
import { FlightSearchComponent } from './flight-search/flight-search.component';
import {MatTableModule} from '@angular/material/table';
import { UserHomepageComponent } from './user-homepage/user-homepage.component';
import {MatCheckboxModule} from '@angular/material/checkbox';
import { FlightBookingComponent } from './flight-booking/flight-booking.component';
import { PassengerComponent } from './passenger/passenger.component';
import { TicketSearchComponent } from './ticket-search/ticket-search.component';
import { UserHistoryComponent } from './user-history/user-history.component';
import { CancelTicketComponent } from './cancel-ticket/cancel-ticket.component';
import {MatDatepickerModule} from '@angular/material/datepicker';
const routes:Routes = [
  {path: 'homepage',component: UserHomepageComponent, children: [
  {path:"searchflights", component:FlightSearchComponent},
  {path:"book/:id", component:FlightBookingComponent},
  {path:"addpassenger/:numberofpassenger",component:PassengerComponent},
  {path:"searchticketbypnr" , component:TicketSearchComponent},
  {path:"userhistory", component:UserHistoryComponent},
  {path:"cancelticket", component:CancelTicketComponent}
  ]
}
  // {path:"homepage/addairline", component:AddAirlineComponent}
]


@NgModule({
  declarations: [FlightSearchComponent,UserHomepageComponent,FlightBookingComponent, PassengerComponent,TicketSearchComponent, UserHistoryComponent,CancelTicketComponent],
  imports: [
    CommonModule,
    MatCheckboxModule,
    MatCardModule,
    MatInputModule,
    MatSidenavModule,
    MatDatepickerModule,
    MatSlideToggleModule,
    MatSliderModule,
    MatMenuModule,
    MatTableModule,
    ReactiveFormsModule,
    FormsModule,
    MatButtonModule,
    MatToolbarModule,
    MatIconModule,
    MatCardModule,
    MatFormFieldModule,
    MatListModule,
    HttpClientModule,
    RouterModule.forChild(routes)
  ]
})
export class UserModule { 
  constructor(){
  }
}
