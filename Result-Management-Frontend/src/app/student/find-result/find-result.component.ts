import { Component, OnInit } from '@angular/core';
import { FormGroup , FormControl , Validators} from '@angular/forms';
import { Result } from 'src/app/entity/result';
import {StudentServicesService} from 'src/app/student/services/student-services.service'


@Component({
  selector: 'app-find-result',
  templateUrl: './find-result.component.html',
  styleUrls: ['./find-result.component.css']
})
export class FindResultComponent implements OnInit {

  constructor(private service : StudentServicesService) { }

  list : Result [] = [];


  ngOnInit(): void {
  }

  findForm = new FormGroup({
    rollNumber : new FormControl('',[Validators.pattern('[0-9]*'),Validators.required]),
    dob : new FormControl('',[Validators.required])
  });
  
  get Form() { return this.findForm.invalid }

  onSubmit(){
    console.warn(this.findForm.value)
    this.service.getByRollnumberAndDob(this.findForm.value.rollNumber , this.findForm.value.dob).subscribe(
      (data)=>{this.list=data;},
      (error)=>{alert("Wrong Roll Number or DOB")}
    )
  }
}
