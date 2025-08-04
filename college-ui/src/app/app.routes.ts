import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { CoursesComponent } from './pages/courses/courses.component';
import { MarksComponent } from './pages/marks/marks.component';
import { FeesComponent } from './pages/fees/fees.component';
import { authGuard } from './services/auth.guard';

export const routes: Routes = [
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
    {
        path: 'dashboard',
        component: DashboardComponent,
        canActivate: [authGuard], // Protect this route and its children
        children: [
            { path: 'courses', component: CoursesComponent },
            { path: 'marks', component: MarksComponent },
            { path: 'fees', component: FeesComponent },
            { path: '', redirectTo: 'courses', pathMatch: 'full' } // Default dashboard view
        ]
    },
    { path: '', redirectTo: 'login', pathMatch: 'full' }
];