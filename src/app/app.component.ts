import { Component, Input } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { Router, RouterModule, Routes } from '@angular/router';
import { Airline } from "src/modules/admin/model/airline";
import { AddAirlineService } from "src/modules/admin/services/add-airline.service";
@Component({
    selector: "app-root",
    templateUrl: "app.component.html",
    styleUrls: ["app.component.css"]
  })
export class AppComponent{
  airline : Airline[]=[];
  constructor(public airlineService:AddAirlineService,private router:Router){
  }


login(){
  const logoutNode = document.querySelector('.logout');
  logoutNode?.setAttribute("style","display:block;");

  const logInNode = document.querySelector('.login');
  logInNode?.setAttribute("style","display:none;");
}

bookflight(){
  const logoutNode = document.querySelector('.logout');
  logoutNode?.setAttribute("style","display:none;");

  const logInNode = document.querySelector('.login');
  logInNode?.setAttribute("style","display:block;");
}

logout(){
  sessionStorage.clear()
  this.router.navigate(['/login']);
}
  
}




