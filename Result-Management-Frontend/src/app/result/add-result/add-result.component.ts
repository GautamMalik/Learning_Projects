import { Component, OnInit } from '@angular/core';
import { FormGroup , FormControl , Validators} from '@angular/forms';
import {ResultServicesService} from 'src/app/result/services/result-services.service'
import { Result } from 'src/app/entity/result';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-result',
  templateUrl: './add-result.component.html',
  styleUrls: ['./add-result.component.css']
})
export class AddResultComponent implements OnInit {

  constructor(private service : ResultServicesService , private _route : Router) { }

  data = new Result();

  ngOnInit(): void {
  }

  addForm = new FormGroup({
    rollNumber : new FormControl('',[Validators.pattern('[0-9]*'),Validators.required]),
    name : new FormControl('',[Validators.pattern('[a-zA-Z]*'),Validators.required]),
    score : new FormControl('',[Validators.pattern('[0-9]*'),Validators.required]),
    dob : new FormControl('',[Validators.required])
  });
  
  get Form() { return this.addForm.invalid }

  onSubmit(){
    this.data.rollNumber=this.addForm.value.rollNumber;
    this.data.name=this.addForm.value.name;
    this.data.dob=this.addForm.value.dob;
    this.data.score=this.addForm.value.score;

    this.service.saveResult(this.data).subscribe(
      (data)=>{alert("Added Successfully");
      this._route.navigate(["/teacher/main"]);
    },
      (error)=>{alert("Result with this Roll Number Already Exist");}
    )
    
  }

}
