import { Component, OnInit, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { StudentService } from './services/student.service';


@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App implements OnInit {

  protected readonly title = signal('frontend');

  constructor(private studentService: StudentService) {}

  ngOnInit(): void {
    this.studentService.getStudents().subscribe({
      next: students => console.log(students),
      error: err => console.error(err)
    });
  }
}
