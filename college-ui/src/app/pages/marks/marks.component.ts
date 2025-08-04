import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-marks',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './marks.component.html',
  styleUrls: ['./marks.component.css']
})
export class MarksComponent implements OnInit {
  marks: any[] = [];

  constructor(private authService: AuthService) {}

  ngOnInit(): void {
    this.authService.getStudentDetails().subscribe({
      next: data => this.marks = data.marks,
      error: err => console.error(err)
    });
  }
}