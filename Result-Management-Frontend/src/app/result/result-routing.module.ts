import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddResultComponent } from './add-result/add-result.component';
import { MainComponent } from './main/main.component';
import { UpdateResultComponent } from './update-result/update-result.component';


const routes: Routes = [
  {
    path : 'teacher' , children: [
      {path : 'main' , component : MainComponent},
      {path : 'add' , component : AddResultComponent},
      {path : 'update/:id' , component : UpdateResultComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ResultRoutingModule { }
