import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MainRoutingModule } from './main-routing.module';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ViewPostComponent } from './view-post/view-post.component';
import { AddPostComponent } from './add-post/add-post.component';
import { AddReplyComponent } from './add-reply/add-reply.component';
import { MyPostsComponent } from './my-posts/my-posts.component';
import { FilterPipe } from './pipe/filter.pipe';
import { SortPipe } from './pipe/sort.pipe';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';



@NgModule({
  declarations: [
    HomeComponent,
    NavbarComponent,
    ViewPostComponent,
    AddPostComponent,
    AddReplyComponent,
    MyPostsComponent,
    FilterPipe,
    SortPipe,
  ],
  imports: [
    CommonModule,
    MainRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgbModule
  ],
  exports:[
    HomeComponent
  ]
})
export class MainModule { }
