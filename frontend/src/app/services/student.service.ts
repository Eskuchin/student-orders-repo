import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { StudentResponse } from '../models/student-response';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private readonly apiUrl = 'http://localhost:8080/students';

  constructor(private http: HttpClient) {}

  getStudents(): Observable<StudentResponse[]> {
    return this.http.get<StudentResponse[]>(this.apiUrl);
  }
}
