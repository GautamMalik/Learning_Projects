import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Result} from 'src/app/entity/result'


@Injectable({
  providedIn: 'root'
})
export class ResultServicesService {

  private url='http://localhost:8084/result';
  constructor(private http : HttpClient) { }

  getAllResult() : Observable<Result[]>{
    return this.http.get<Result[]>(`${this.url}`);
  }

  saveResult(data : Result) : Observable<string>{
      return this.http.post<string>(this.url,data,{responseType:'text' as 'json'})
  }

  deleteResult(data : number) : Observable<string>{
    return this.http.delete<string>(this.url+"/"+data,{responseType:'text' as 'json'});
  }

  updateResult(data : Result) : Observable<Result>{
    return this.http.put<Result>(this.url,data);
  }


}
