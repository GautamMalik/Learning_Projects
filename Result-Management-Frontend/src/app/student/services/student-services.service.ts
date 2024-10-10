import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Result} from 'src/app/entity/result'

@Injectable({
  providedIn: 'root'
})
export class StudentServicesService {

  private url='http://localhost:8084/result';
  constructor(private http : HttpClient) { }

  getByRollnumberAndDob (rollNumber : number , dob : string) : Observable<Result[]>{
    return this.http.get<Result[]>(`${this.url}/${rollNumber}/${dob}`);
  }
}
