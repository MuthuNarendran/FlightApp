import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from "@angular/forms";
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import {MatButtonModule} from '@angular/material/button';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatSliderModule} from '@angular/material/slider';
import {MatMenuModule} from '@angular/material/menu';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatCardModule} from '@angular/material/card';
import { RouterModule, Routes } from '@angular/router';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { HttpClientModule } from '@angular/common/http';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { LoginComponent } from './login/login.component';
import {MatNativeDateModule, MAT_DATE_LOCALE} from '@angular/material/core';
import { FirstComponent } from './first/first.component';
const routes: Routes = [
  {path:'',component:FirstComponent},
   {path:'admin', loadChildren:()=>import("../modules/admin/admin.module").then(admin=>admin.AdminModule)},
   {path:'user', loadChildren:()=>import("../modules/user/user.module").then(user=>user.UserModule)},
   {path:"login", component:LoginComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    FirstComponent
  ],
  imports: [
    BrowserModule,
    MatInputModule,
    FormsModule,
    MatNativeDateModule,
    BrowserAnimationsModule,
    MatDatepickerModule,
    MatSidenavModule,
    MatSlideToggleModule,
    MatSliderModule,
    MatMenuModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatToolbarModule,
    MatIconModule,
    MatCardModule,
    MatFormFieldModule,
    HttpClientModule,
    [RouterModule.forRoot(routes)]
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
