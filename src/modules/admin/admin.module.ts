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
import { AdminHomepageComponent } from './component/admin-homepage/admin-homepage.component';
import {MatListModule} from '@angular/material/list';
import { AddAirlineComponent } from './component/add-airline/add-airline.component';
import { HttpClientModule } from '@angular/common/http';
import { AddFlightComponent } from './component/add-flight/add-flight.component';
import { BlockAirlineComponent } from './block-airline/block-airline.component';
import { AuthGuard } from 'src/modules/admin/authGuard';
import {MatDatepickerModule} from '@angular/material/datepicker';
const routes:Routes = [
  {path: 'homepage',component: AdminHomepageComponent, canActivate : [AuthGuard], children: [
    {path:"addairline", component:AddAirlineComponent},
    {path:"addflight", component:AddFlightComponent},
    {path:"blockairline",component:BlockAirlineComponent}
    ]
}
  // {path:"homepage/addairline", component:AddAirlineComponent}
]

@NgModule({
  declarations: [AdminHomepageComponent, AddAirlineComponent,AddFlightComponent,BlockAirlineComponent],
  imports: [
    CommonModule,
    MatInputModule,
    MatCardModule,
    MatDatepickerModule,
    MatSidenavModule,
    MatSlideToggleModule,
    MatSliderModule,
    MatMenuModule,
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
  ],
})
export class AdminModule { 
  constructor(){
  }
}
