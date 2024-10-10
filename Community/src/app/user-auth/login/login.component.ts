import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms'
import { Router } from '@angular/router';
import { Login } from 'src/app/entity/login';
import { UserAuthServicesService } from '../services/user-auth-services.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private service : UserAuthServicesService , private _route : Router) { }

  ngOnInit(): void {
  }

  user : Login[]= [] ;

  loginForm = new FormGroup({
    email : new FormControl('',[Validators.required , Validators.minLength(4), Validators.email]),
    password : new FormControl('',[Validators.required , Validators.minLength(4)])
  });
  get Form() { return this.loginForm.invalid }

  onSubmit(){
    this.service.getByEmailAndPassword(this.loginForm.value.email , this.loginForm.value.password).subscribe(
      (data)=>{
        this.user=data;
        this._route.navigate(['/home'])
      },
      (error)=>{
        alert("Invalid email or password")
      }
    );

    
    sessionStorage.setItem("email",this.loginForm.value.email);
    sessionStorage.setItem("password",this.loginForm.value.password);   
  }

}
