import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Question } from 'src/app/entity/question';
import { MainServicesService } from '../services/main-services.service';

@Component({
  selector: 'app-my-posts',
  templateUrl: './my-posts.component.html',
  styleUrls: ['./my-posts.component.css']
})
export class MyPostsComponent implements OnInit {

  constructor(private _route : Router , private service : MainServicesService) { }

  posts : Question[]=[];
  searchKey:string='';
  author:any=sessionStorage.getItem("email");

  dropdown:string=''

  ngOnInit(): void {
    if (sessionStorage.getItem('email')==null || sessionStorage.getItem('password')==null){
      this._route.navigate(['/user/login'])
  }

  this.service.getByAuthor(this.author).subscribe(
    (data)=>{this.posts=data}
  );
  }

  getSearch(item:any){
    this.searchKey=item;
  }

  selectDropdownHandeller(event : any){
    this.dropdown=event.target.value
    console.warn(this.dropdown)
  }

}
