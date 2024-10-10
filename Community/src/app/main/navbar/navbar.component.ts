import { Component, OnInit , Output , EventEmitter} from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { Login } from 'src/app/entity/login';
import { Question } from 'src/app/entity/question';
import { UserAuthServicesService } from 'src/app/user-auth/services/user-auth-services.service';
import { MainServicesService } from '../services/main-services.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  users : Login[] =[];
  posts: Question[]=[];
  show:boolean =false;

  

  constructor(private _route : Router, private userService : UserAuthServicesService, private questionService : MainServicesService) { }

  ngOnInit(): void {
    this.userService.getAllUsers().subscribe((data)=>{this.users=data});
    this.questionService.getAllPosts().subscribe((data)=>{this.posts=data});
  }

  logout = new FormGroup({})
  
  searchForm = new FormGroup({
    search : new FormControl('')
  })

  @Output() getSearchEvent = new EventEmitter<string>();

  Search(){
    this.getSearchEvent.emit(this.searchForm.value.search);
  }

  Logout(){
    sessionStorage.removeItem("email");
    sessionStorage.removeItem("password");
    this._route.navigate(['/user/login'])
  }

  Stats(){
    this.show=!this.show;
  }

}
