import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FindResultComponent } from './find-result/find-result.component';

const routes: Routes = [
  {
    path:'student' , children:[
      {path:'findResult' , component : FindResultComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StudentRoutingModule { }
