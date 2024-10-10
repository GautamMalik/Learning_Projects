import { Component, OnInit } from '@angular/core';
import {FormControl , FormGroup ,Validators } from '@angular/forms'
import { Login } from 'src/app/entity/login';
import { UserServicesService } from '../services/user-services.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private service : UserServicesService) { }

  user : Login= new Login();
  msg : string=''

  ngOnInit(): void { }

  signupForm = new FormGroup({
    email : new FormControl('',[Validators.required,Validators.minLength(4),Validators.email]),
    password : new FormControl('',[Validators.required,Validators.minLength(4)])
  })



  onSubmit(){
    console.warn(this.signupForm.value);
    this.user.email = this.signupForm.value.email;
    this.user.password = this.signupForm.value.password;

    this.service.saveUser(this.user).subscribe((data)=>{
      this.msg=data;
    });

    alert('User Registered Succesfully');
}

  get email(){return this.signupForm.get('email')}
  get password(){return this.signupForm.get('password')}
  get Form(){return this.signupForm.invalid}

}

