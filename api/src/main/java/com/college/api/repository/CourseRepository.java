package com.college.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.college.api.model.Course;

public interface CourseRepository extends MongoRepository<Course, String> {}