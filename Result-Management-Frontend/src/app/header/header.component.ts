import { Component, OnInit } from '@angular/core';
import { UserServicesService } from '../user-auth/services/user-services.service';
import {Login} from '../entity/login'

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  user : Login[]=[];

  constructor(private service : UserServicesService) {   }
  

  ngOnInit(): void {
   this.service.getAllUsers().subscribe((data)=>{
     this.user=data;
   })
  }

}
