import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-fees',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './fees.component.html',
  styleUrls: ['./fees.component.css']
})
export class FeesComponent implements OnInit {
  fees: any[] = [];

  constructor(private authService: AuthService) {}

  ngOnInit(): void {
    this.authService.getStudentDetails().subscribe({
      next: data => this.fees = data.fees,
      error: err => console.error(err)
    });
  }

  calculatePercentage(paid: number, total: number): number {
    if (total === 0) {
      return 100;
    }
    return (paid / total) * 100;
  }
}