import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms'
import { Router } from '@angular/router';
import { Login } from 'src/app/entity/login';
import { UserServicesService } from '../services/user-services.service'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private service: UserServicesService, private _route: Router) { }

  ngOnInit(): void {
  }

  user: Login = new Login();
  msg: string = '';


  loginform = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.minLength(4), Validators.email]),
    password: new FormControl('', [Validators.required, Validators.minLength(4)])
  })

  get email() { return this.loginform.get('email') }
  get password() { return this.loginform.get('password') }
  get Form() { return this.loginform.invalid }

  onSubmit() {
    console.warn(this.loginform.value);
    this.user.email = this.loginform.value.email;
    this.user.password = this.loginform.value.password;

    this.service.getByEmailAndPassword(this.user.email, this.user.password).subscribe(
      (data) => {
        this._route.navigate(['/teacher/main']);
        console.log("Login Success");
      },

      (error)  => {
        console.log("Login Failed");
        this.msg = "Invalid Username or Password";
      }
    );

  }



}
