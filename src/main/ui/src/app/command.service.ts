import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

import { Command } from './command';

@Injectable({
  providedIn: 'root',
})
export class CommandService {
  private url: string = '/commands';

  constructor(private http: HttpClient) {}

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
  };

  getCommands(): Observable<Command[]> {
    return this.http.get<Command[]>(this.url, this.httpOptions);
  }
}
