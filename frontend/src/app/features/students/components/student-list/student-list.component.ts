import { Component, OnInit } from '@angular/core';
import { StudentService } from '../../services/student.service';
import { StudentResponse } from '../../models/student-response';
import { CommonModule } from '@angular/common';
import { ChangeDetectorRef } from '@angular/core';
import { signal } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-student-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './student-list.html',
  styleUrl: './student-list.css',
})
export class StudentListComponent implements OnInit {
  students = signal<StudentResponse[]>([]);
  constructor(private studentService: StudentService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.studentService.getStudents().subscribe({
      next: students => this.students.set(students),
      error: err => console.error(err)
    });
  }

  viewOrders(studentId: number): void {
    this.router.navigate(['/students', studentId, 'orders']);
  }

  goToCreateStudent(): void {
    this.router.navigate(['/students/new']);
  }
}
