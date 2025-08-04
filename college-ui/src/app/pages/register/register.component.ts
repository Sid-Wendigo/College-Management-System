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

  constructor(private authService: AuthService, private router: Router) { }

  onRegister(): void {
    if (this.registerData.password !== this.confirmPassword) {
      alert('Passwords do not match.');
      return;
    }
    this.authService.register(this.registerData).subscribe({
      next: () => {
        alert('Registration successful! Please log in.');
        this.router.navigate(['/login']);
      },
      error: (err) => {
        alert(`Registration failed: ${err.error}`);
      }
    });
  }
}
