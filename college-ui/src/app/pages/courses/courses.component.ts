import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-courses',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent implements OnInit {
  courses: any[] = [];

  constructor(private authService: AuthService) {}

  ngOnInit(): void {
    this.authService.getCourses().subscribe({
      next: data => this.courses = data,
      error: err => console.error(err)
    });
  }
}