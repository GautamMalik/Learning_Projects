import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Question } from 'src/app/entity/question';
import { MainServicesService } from '../services/main-services.service';

@Component({
  selector: 'app-view-post',
  templateUrl: './view-post.component.html',
  styleUrls: ['./view-post.component.css']
})
export class ViewPostComponent implements OnInit {

  constructor(private service : MainServicesService , private route : ActivatedRoute, private _route : Router) { }

  id :any;
  post : Question = new Question; 
  author : any = sessionStorage.getItem("email");

  ngOnInit(): void {
    if (sessionStorage.getItem('email')==null || sessionStorage.getItem('password')==null){
      this._route.navigate(['/user/login'])
    }

    this.id=this.route.snapshot.paramMap.get('id');

    this.service.getByID(this.id).subscribe(
      (data)=>{this.post=data},
      (error)=>{alert("No data found")}
    )
  }

  Solution(val: number){
    this.service.markQuestionAsSolved(String(val)).subscribe(
      (data)=>{alert('Question marked as solved');},
      (error)=>{alert('Something went wrong')}
    );
  }

}
