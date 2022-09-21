import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ResponsePayload } from './response-payload';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ResponseService {

  constructor(private httpClient: HttpClient) { }

  getAllResponsesForPost(postId: number): Observable<ResponsePayload[]> {
    return this.httpClient.get<ResponsePayload[]>('http://localhost:8080/api/responses/by-post/' + postId);
  }

  postResponse(responsePayload: ResponsePayload): Observable<any> {
    return this.httpClient.post<any>('http://localhost:8080/api/responses/', responsePayload);
  }

  getAllResponsesByUser(name: string) {
    return this.httpClient.get<ResponsePayload[]>('http://localhost:8080/api/responses/by-user/' + name);
  }
}