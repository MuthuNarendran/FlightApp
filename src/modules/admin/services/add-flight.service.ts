import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AddFlightService {

  private addFlightUrl:string = "http://localhost:8989/api/v1.0/admin/flight/airline/inventory/add";
  jwtToken!:any;
  header!:any;
  constructor(private httpClient:HttpClient) { }

  saveFlights(FlightObj:any){
    this.jwtToken = sessionStorage.getItem('token');
    console.log(this.jwtToken)
    this.header= new HttpHeaders().set('Authorization',this.jwtToken);
    return this.httpClient.post(this.addFlightUrl, FlightObj,{headers:this.header});
  }
}