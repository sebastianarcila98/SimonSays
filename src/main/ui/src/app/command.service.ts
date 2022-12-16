import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

import { Command } from './command';

@Injectable({
  providedIn: 'root',
})
export class CommandService {
  private baseUrl: string = '/commands';

  constructor(private http: HttpClient) {}

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
  };

  getAllCommands(): Observable<Command[]> {
    return this.http.get<Command[]>(this.baseUrl, this.httpOptions);
  }

  deleteCommand(id: number): Observable<void> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.delete<void>(url);
  }

  getRandomCommand(): Observable<Command> {
    return this.http.get<Command>(`${this.baseUrl}/random`);
  }
}
