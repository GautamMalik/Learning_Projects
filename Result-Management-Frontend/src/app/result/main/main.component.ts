import { Component, OnInit } from '@angular/core';
import { ResultServicesService } from '../services/result-services.service';
import { Result} from 'src/app/entity/result'
import { asLiteral } from '@angular/compiler/src/render3/view/util';
import { Router } from '@angular/router';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  constructor(private service : ResultServicesService , private _route : Router) { }

  list : Result [] = [];

  ngOnInit(): void {
    this.service.getAllResult().subscribe((data)=>{
      this.list=data;
    })
  }

  delete(id:number){
    
    this.service.deleteResult(id).subscribe((data)=>{
      alert("deleted");
      this._route.navigate(['/teacher/main'])
    });
     this.list.splice(id-1,1);
    

  }

}
