# College Management System (CMS)

A full-stack web application built from scratch that provides a secure portal for students to manage their academic information. This project features a modern, responsive frontend built with Angular and a secure REST API backend powered by Spring Boot and MongoDB.

---

## ✨ Features

- **Secure Authentication:** Users can register and log in via a professional user interface. The system uses JSON Web Tokens (JWTs) for secure, token-based authentication.
- **Personalized Dashboard:** After logging in, students are greeted with a dashboard layout that provides easy navigation to different modules.
- **Modular Information Pages:** The application features separate, protected pages for viewing:
    - **Course Details:** A list of available courses offered by the college.
    - **My Marks:** A personalized view of the student's marks for their enrolled subjects.
    - **My Fees:** A summary of the student's current fee status.
- **Direct Data Management:** Courses and student marks can be managed directly in the MongoDB database using tools like MongoDB Compass.

---

## 🛠️ Tech Stack

- **Backend:** Java 17, Spring Boot 3, Spring Security, MongoDB
- **Frontend:** Angular 17, TypeScript, HTML/CSS
- **API Testing:** Thunder Client / Postman
- **Database Management:** MongoDB Compass

---

## 🚀 Running Locally

To run this project on your local machine:

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/YourUsername/YourRepositoryName.git](https://github.com/YourUsername/YourRepositoryName.git)
    cd YourRepositoryName
    ```

2.  **Run the Backend:**
    - Make sure you have a local MongoDB instance running.
    - Navigate to the `api` folder: `cd api`
    - Build the project: `.\mvnw.cmd install`
    - Run the application: Start the `ApiApplication.java` file. The backend will run on `http://localhost:8080`.

3.  **Run the Frontend:**
    - Navigate to the `college-ui` folder: `cd college-ui`
    - Install dependencies: `npm install`
    - Start the development server: `ng serve`
    - Open your browser and navigate to `http://localhost:4200`.