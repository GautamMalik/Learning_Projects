import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import {  Router } from '@angular/router';
import { Question } from 'src/app/entity/question';
import { MainServicesService } from '../services/main-services.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private _route : Router , private service : MainServicesService) { }

  posts : Question[]=[];
  searchKey:string='';

  dropdown:string=''

  ngOnInit(): void {
    if (sessionStorage.getItem('email')==null || sessionStorage.getItem('password')==null){
      this._route.navigate(['/user/login'])
    }

    this.service.getAllPosts().subscribe(
      (data)=>{this.posts=data}
    )

  }

  getSearch(item:any){
    this.searchKey=item;
  }

  selectDropdownHandeller(event : any){
    this.dropdown=event.target.value
    console.warn(this.dropdown)
  }
}
