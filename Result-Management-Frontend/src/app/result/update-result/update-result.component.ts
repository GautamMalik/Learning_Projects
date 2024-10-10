import { Component, OnInit } from '@angular/core';
import { FormGroup , FormControl , Validators} from '@angular/forms';
import {ResultServicesService} from 'src/app/result/services/result-services.service'
import { Result } from 'src/app/entity/result';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-result',
  templateUrl: './update-result.component.html',
  styleUrls: ['./update-result.component.css']
})
export class UpdateResultComponent implements OnInit {

  id:number=-1;
  data = new Result;

  constructor(private route : ActivatedRoute , private service : ResultServicesService , private _route : Router) { }

  ngOnInit(): void {
   
    this.id=this.route.snapshot.params['id']
  }

  updateForm = new FormGroup({
    rollNumber : new FormControl(this.route.snapshot.params['id'],[Validators.pattern('[0-9]*'),Validators.required]),
    name : new FormControl('',[Validators.pattern('[a-zA-Z]*'),Validators.required]),
    score : new FormControl('',[Validators.pattern('[0-9]*'),Validators.required]),
    dob : new FormControl('',[Validators.required])
  });

  get Form() { return this.updateForm.invalid }

  onSubmit(){
    this.data.rollNumber=this.updateForm.value.rollNumber;
    this.data.name=this.updateForm.value.name;
    this.data.score=this.updateForm.value.score;
    this.data.dob=this.updateForm.value.dob;

    this.service.updateResult(this.data).subscribe((res)=>{
      alert("Result Updated");
      this._route.navigate(['/teacher/main']);
    });
  }

}
