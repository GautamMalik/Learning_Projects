import { Component, OnInit } from '@angular/core';
import { FormGroup , FormControl , Validators } from '@angular/forms';
import { Login } from 'src/app/entity/login';
import { UserAuthServicesService } from '../services/user-auth-services.service';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {

  user : Login[] =[];

  constructor(private service : UserAuthServicesService) { }

  ngOnInit(): void {
  }

  forgotPasswordForm = new FormGroup({
    email : new FormControl('', [Validators.email , Validators.minLength(4) , Validators.required]),
  })
  get Form() { return this.forgotPasswordForm.invalid }

  onSubmit(){
    this.service.getByEmail(this.forgotPasswordForm.value.email).subscribe(
      (data)=>{this.user=data},
      (error)=>{alert("Invalid Email")}
    )
  }
}
