import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AddAirlineService {

  token!:string;
  header!:HttpHeaders;
  jwtToken!:any;
  private addAirlineUrl:string = "http://localhost:8989/api/v1.0/admin/flight/airline/register";

  constructor(private httpClient:HttpClient) { }

//   readAll(){
//     return this.httpClient.get(this.url);
//   }

  saveAirline(airlineObj:any){
      this.jwtToken = sessionStorage.getItem('token');
      console.log(this.jwtToken)
      this.header= new HttpHeaders().set('Authorization',this.jwtToken);
    return this.httpClient.post(this.addAirlineUrl, airlineObj,{headers:this.header});
  }

  updateAirline(airlineObj:any){
    this.jwtToken = sessionStorage.getItem('token');
    console.log(this.jwtToken)
    this.header= new HttpHeaders().set('Authorization',this.jwtToken);
  return this.httpClient.put(this.addAirlineUrl, airlineObj,{headers:this.header});
}
}