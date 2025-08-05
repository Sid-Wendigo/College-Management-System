import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterLink],
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  registerData = { email: '', password: '' };
  confirmPassword = '';
  errorMessage: string | null = null;

  constructor(private authService: AuthService, private router: Router) { }

  onRegister(): void {
    this.errorMessage = null;

    if (this.registerData.password !== this.confirmPassword) {
      this.errorMessage = 'Passwords do not match.';
      return;
    }

    this.authService.register(this.registerData).subscribe({
      next: () => {
        alert('Registration successful! Please log in.');
        this.router.navigate(['/login']);
      },
      error: (err) => {
        this.errorMessage = typeof err.error === 'string' ? err.error : 'Registration failed. Please try again.';
        console.error('Registration failed!', err);
      }
    });
  }
}