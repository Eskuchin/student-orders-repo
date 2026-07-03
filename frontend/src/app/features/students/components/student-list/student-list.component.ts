import { Component, OnInit, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

import { StudentService } from '../../services/student.service';
import { StudentResponse } from '../../models/student-response';

@Component({
  selector: 'app-student-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './student-list.html',
  styleUrl: './student-list.css',
})
export class StudentListComponent implements OnInit {

  students = signal<StudentResponse[]>([]);
  loading = signal(true);

  constructor(
    private studentService: StudentService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadStudents();
  }

  loadStudents(): void {

    this.loading.set(true);

    this.studentService.getStudents().subscribe({
      next: students => {
        this.students.set(students);
        this.loading.set(false);
      },
      error: err => {
        console.error(err);
        this.loading.set(false);
      }
    });

  }

  viewOrders(studentId: number): void {
    this.router.navigate(['/students', studentId, 'orders']);
  }

  goToCreateStudent(): void {
    this.router.navigate(['/students/new']);
  }

}
