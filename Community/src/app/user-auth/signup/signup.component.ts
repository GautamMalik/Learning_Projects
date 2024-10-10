import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import {  Router } from '@angular/router';
import { Login } from 'src/app/entity/login';
import { UserAuthServicesService } from '../services/user-auth-services.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private service: UserAuthServicesService , private _route : Router) { }

  msg: string = '';
  user: Login = new Login;

  ngOnInit(): void {
  }

  signupForm = new FormGroup({
    email: new FormControl('', [Validators.email, Validators.minLength(4), Validators.required]),
    fname: new FormControl('', [Validators.required, Validators.minLength(3), Validators.pattern('[a-zA-z]*')]),
    lname: new FormControl('', [Validators.required, Validators.minLength(3), Validators.pattern('[a-zA-z]*')]),
    password: new FormControl('', [Validators.required, Validators.minLength(4)]),
  })

  get Form() { return this.signupForm.invalid }


  onSubmit() {
    console.warn(this.signupForm.value);
    this.user.firstName = this.signupForm.value.fname;
    this.user.lastName = this.signupForm.value.lname;
    this.user.email = this.signupForm.value.email;
    this.user.password = this.signupForm.value.password;

    this.service.saveUser(this.user).subscribe(
      (data) => {
        alert("User Added Successfully");
        this._route.navigate(['/user/login'])
      },
      (error) => {
        alert("User with this email already exist");
      }

    );

  }
}
