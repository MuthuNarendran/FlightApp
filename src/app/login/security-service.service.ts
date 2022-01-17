import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SecurityServiceService {

  constructor(private httpClient:HttpClient) { }

  private loginUrl:string = "http://localhost:8989/login";

  public generateToken(loginRequest:any){
    return this.httpClient.post(this.loginUrl,loginRequest,{responseType:'text' as 'json'});
  }

}
