import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { Router } from '@angular/router';
import { SecurityServiceService } from 'src/app/login/security-service.service';
import { AuthService } from '../AuthService';

@Component({
  selector: 'app-loginPage',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  myForm: FormGroup;
  bg: string = "green";
  headerStyle = {
    "color": "black;",
    "padding": "20px"
  }
  errorMessage = '';
  isLoggedin = false;
  isLoginFailed = false;
  submitted = false;

  constructor(private router: Router, private securityServiceService: SecurityServiceService,private authService:AuthService) {
    this.myForm = new FormGroup({
      username: new FormControl("", [
        Validators.required,
        Validators.minLength(2),
        Validators.maxLength(10)
      ]),
      password: new FormControl("", [
        Validators.required,
        Validators.minLength(2),
        Validators.maxLength(15)
      ])
    });
  }

  onSubmit(data: any) {
    this.generateToken(data);
  }
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  generateToken(data: any) {
    this.submitted = true;
    this.securityServiceService.generateToken(data).subscribe((res: any) => {
      this.isLoggedin = true;
      this.authService.setLoggedIn(this.isLoggedin);
      this.router.navigate(["/", "admin", "homepage"])
      let tokenRes = res.split(":")[1].replace("}", '')
      let tokenStr = "Bearer " + tokenRes.slice(1, -1);
      console.log("Token---  " + tokenStr);
      sessionStorage.setItem("token", tokenStr);
    },
      error => {
        console.log(error);
        this.isLoggedin = false;
        this.isLoginFailed = true;
      }
    );
  }
}
