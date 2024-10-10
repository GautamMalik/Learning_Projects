import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ResultRoutingModule } from './result-routing.module';
import { MainComponent } from './main/main.component';
import { AddResultComponent } from './add-result/add-result.component';
import { UpdateResultComponent } from './update-result/update-result.component';
import { MatFormFieldModule } from "@angular/material/form-field";

import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [
    MainComponent,
    AddResultComponent,
    UpdateResultComponent,
  ],
  imports: [
    CommonModule,
    ResultRoutingModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    HttpClientModule    
    
  ],
  exports : [
    MainComponent,
    AddResultComponent,
    UpdateResultComponent
  ]
})
export class ResultModule { }
