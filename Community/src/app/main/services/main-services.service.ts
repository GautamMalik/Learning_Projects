import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Question } from 'src/app/entity/question';
import { PostQuestionDto } from 'src/app/entity/post-question-dto';
import { Replies } from 'src/app/entity/replies'

@Injectable({
  providedIn: 'root'
})
export class MainServicesService {

  constructor(private http: HttpClient) { }

  private url = "http://localhost:8084/question";

  private url2 = "http://localhost:8084/reply";

  private url3 = "http://localhost:8084/author"

  getAllPosts(): Observable<Question[]> {
    return this.http.get<Question[]>(`${this.url}`);
  }

  getByID(id: string): Observable<Question> {
    return this.http.get<Question>(`${this.url + "/" + id}`)
  }

  saveQuestion(data: PostQuestionDto) {
    return this.http.post(this.url, data, { responseType: 'text' as 'json' });
  }

  markQuestionAsSolved(id: string) {
    return this.http.put(this.url + "/" + id, { responseType: 'text' as 'json' });
  }

  addReply(id: string, data: Replies) {
    return this.http.put(this.url2 + "/" + id, data , { responseType: 'text' as 'json' });
  }

  getByAuthor(author: string): Observable<Question[]> {
    return this.http.get<Question[]>(`${this.url3 + "/" + author}`);
  }
}
