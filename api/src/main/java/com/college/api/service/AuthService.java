package com.college.api.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.college.api.model.Course;
import com.college.api.model.Fee;
import com.college.api.model.Mark;
import com.college.api.model.Student;
import com.college.api.model.User;
import com.college.api.repository.CourseRepository;
import com.college.api.repository.StudentRepository;
import com.college.api.repository.UserRepository;
import com.college.api.util.JwtUtil;

@Service
public class AuthService {
    @Autowired private UserRepository userRepository;
    @Autowired private StudentRepository studentRepository;
    @Autowired private CourseRepository courseRepository;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private AuthenticationManager authenticationManager;
    @Autowired private JwtUtil jwtUtil;

    public User registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email is already taken!");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);

        List<Course> coursesToEnroll = courseRepository.findAll().stream().limit(3).collect(Collectors.toList());
        List<String> courseIds = coursesToEnroll.stream().map(Course::getId).collect(Collectors.toList());
        List<Mark> initialMarks = coursesToEnroll.stream()
            .map(course -> new Mark(course.getCourseName(), (int) (Math.random() * 41) + 60))
            .collect(Collectors.toList());
        
        Student student = new Student();
        student.setUserId(savedUser.getId());
        student.setFirstName("New");
        student.setLastName("Student");
        student.setEnrolledCourseIds(courseIds);
        student.setMarks(initialMarks);
        student.setFees(List.of(new Fee(new BigDecimal("50000"), new BigDecimal("25000"), new Date())));
        studentRepository.save(student);

        return savedUser;
    }
    
    public String loginUser(String email, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        return jwtUtil.generateToken(email);
    }
}