import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators
} from '@angular/forms';
import { Router } from '@angular/router';

import { StudentService } from '../../services/student.service';
import { SchoolService } from '../../../schools/services/school.service';

import { School } from '../../../schools/models/school';
import { StudentRequest } from '../../models/student-request';

@Component({
  selector: 'app-student-create',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule
  ],
  templateUrl: './student-create.component.html',
  styleUrl: './student-create.component.css'
})
export class StudentCreateComponent implements OnInit {

  schools: School[] = [];

  form: FormGroup;

  constructor(
    private fb: FormBuilder,
    private studentService: StudentService,
    private schoolService: SchoolService,
    private router: Router
  ) {

    this.form = this.fb.group({
      firstName: [
        '',
        [Validators.required]
      ],

      lastName: [
        '',
        [Validators.required]
      ],

      email: [
        '',
        [
          Validators.required,
          Validators.email
        ]
      ],

      grade: [
        1,
        [
          Validators.required,
          Validators.min(1),
          Validators.max(10)
        ]
      ],

      schoolId: [
        null,
        Validators.required
      ]
    });
  }

  ngOnInit(): void {
    this.loadSchools();
  }

  loadSchools(): void {
    this.schoolService.getSchools().subscribe({
      next: schools => this.schools = schools,
      error: err => console.error('Failed to load schools', err)
    });
  }

  onSubmit(): void {

    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }

    const request: StudentRequest = this.form.value as StudentRequest;

    this.studentService.createStudent(request).subscribe({
      next: () => this.router.navigate(['/students']),
      error: err => console.error('Create failed', err)
    });
  }

  goBack(): void {
    this.router.navigate(['/students']);
  }

  get firstName() {
    return this.form.get('firstName');
  }

  get lastName() {
    return this.form.get('lastName');
  }

  get email() {
    return this.form.get('email');
  }

  get grade() {
    return this.form.get('grade');
  }

  get schoolId() {
    return this.form.get('schoolId');
  }
}
