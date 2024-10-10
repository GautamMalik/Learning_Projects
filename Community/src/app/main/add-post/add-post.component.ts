import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { PostQuestionDto } from 'src/app/entity/post-question-dto';
import { Question } from 'src/app/entity/question';
import { MainServicesService } from '../services/main-services.service';

@Component({
  selector: 'app-add-post',
  templateUrl: './add-post.component.html',
  styleUrls: ['./add-post.component.css']
})
export class AddPostComponent implements OnInit {

  constructor(private service : MainServicesService , private _route : Router) { }

  question : Question = new Question();
  post : PostQuestionDto = new PostQuestionDto();

  today : Date= new Date();
  month:any;
  year:any;
  date:any;
  curr_date:any;

  ngOnInit(): void {
    if (sessionStorage.getItem('email')==null || sessionStorage.getItem('password')==null){
      this._route.navigate(['/user/login'])
    }
  }

  addForm = new FormGroup({
    title : new FormControl('',[Validators.required , Validators.minLength(5)]),
    body : new FormControl('',[Validators.required , Validators.minLength(20)])
  });

  get Form() {return this.addForm.invalid}

  onSubmit(){
    console.warn(this.addForm.value);

    this.year = this.today.getFullYear();
    this.month=this.today.getMonth() +1;
    this.date=this.today.getDate();
    this.curr_date = this.date + "/" + this.month + "/" + this.year;

    this.question.author=sessionStorage.getItem("email");
    this.question.title=this.addForm.value.title;
    this.question.body=this.addForm.value.body;
    this.question.date=this.curr_date;
    this.question.solved="false";
    this.question.replies=[];

    this.post.question=this.question;

    this.service.saveQuestion(this.post).subscribe(
      (data)=>{
        alert("added successfully");
        this._route.navigate(['/home']);
      },
      (error)=>{alert('Something went wrong');}
    );

  }

}
