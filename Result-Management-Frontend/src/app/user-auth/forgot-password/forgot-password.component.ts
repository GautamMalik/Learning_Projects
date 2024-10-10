import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms'
import { Login } from 'src/app/entity/login';
import { UserServicesService } from '../services/user-services.service';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {

  constructor(private service: UserServicesService) { }

  user: Login = new Login();
  users: Login[] = [];
  msg: string = '';

  ngOnInit(): void {
  }

  forgotForm = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.minLength(4), Validators.email]),
  })

  get Form() { return this.forgotForm.invalid }

  onSubmit() {
    console.warn(this.forgotForm.value);
    this.user.email = this.forgotForm.value.email;
    this.user.password = this.forgotForm.value.password;

    this.service.getByEmail(this.user.email).subscribe((data) => {
      this.msg = '';
      this.users = data;
    },
      (error) => { this.msg = "Invalid Email"; }
    )
  }

}
