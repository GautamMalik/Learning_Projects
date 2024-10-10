import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';
import { Login } from 'src/app/entity/login';

@Injectable({
  providedIn: 'root'
})
export class UserAuthServicesService {

  constructor(private http : HttpClient) { }

  private url = "http://localhost:8084/login";

  getAllUsers() : Observable<Login[]>{
    return this.http.get<Login[]>(`${this.url}`)
  }

  saveUser(data : Login) : Observable<string>{
    return this.http.post<string>(this.url, data, {responseType : 'text' as 'json'})
  }

  getByEmailAndPassword(email : string , password : string) : Observable<Login[]>{
    return this.http.get<Login[]>(`${this.url+"/"+email + '/' + password}`);
  }

  getByEmail(email:string) :Observable<Login[]>{
    return this.http.get<Login[]>(`${this.url+"/"+email}`);
  }
}
