import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddPostComponent } from './add-post/add-post.component';
import { AddReplyComponent } from './add-reply/add-reply.component';
import { HomeComponent } from './home/home.component';
import { MyPostsComponent } from './my-posts/my-posts.component';
import { ViewPostComponent } from './view-post/view-post.component';

const routes: Routes = [
  {path : 'home' , component : HomeComponent},
  {path : 'view/:id' , component : ViewPostComponent},
  {path : 'reply/:id' , component : AddReplyComponent},
  {path : 'add', component: AddPostComponent},
  {path : 'myposts' , component: MyPostsComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MainRoutingModule { }
