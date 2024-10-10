import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Replies } from 'src/app/entity/replies';
import { MainServicesService } from '../services/main-services.service';

@Component({
  selector: 'app-add-reply',
  templateUrl: './add-reply.component.html',
  styleUrls: ['./add-reply.component.css']
})
export class AddReplyComponent implements OnInit {

  constructor(private route : ActivatedRoute , private service : MainServicesService , private _route : Router) { }

  id : any;
  reply : Replies = new Replies;

  ngOnInit(): void {
    if (sessionStorage.getItem('email')==null || sessionStorage.getItem('password')==null){
      this._route.navigate(['/user/login'])
    }
    
    this.id = this.route.snapshot.paramMap.get('id');
  }

  replyForm = new FormGroup({
    subject: new FormControl('',[Validators.required , Validators.minLength(5)]),
    body : new FormControl('',[Validators.required , Validators.minLength(20)])
  });

  get Form() {return this.replyForm.invalid};

  onSubmit(){
    console.warn(this.replyForm.value);

    this.reply.subject=this.replyForm.value.subject;
    this.reply.body=this.replyForm.value.body;

    this.service.addReply(this.id,this.reply).subscribe(
      (data)=>{
        alert('Reply added successfully');
        this._route.navigate(['/view/'+this.id])
      },
      (error)=>{alert('Something went wrong');}
    );
    
  }
}
