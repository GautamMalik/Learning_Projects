import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import {ReactiveFormsModule} from '@angular/forms';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { UserAuthRouthingModule } from './user-auth-routhing.module';
import {HttpClientModule} from '@angular/common/http'


@NgModule({
  declarations: [
    LoginComponent,
    SignupComponent,
    ForgotPasswordComponent
   
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    UserAuthRouthingModule,
    HttpClientModule
  ],
  exports:[
    LoginComponent,
    SignupComponent,
    ForgotPasswordComponent
  ]
})
export class UserAuthModule { }
