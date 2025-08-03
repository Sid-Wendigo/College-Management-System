package com.college.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "courses")
public class Course {
    @Id private String id;
    private String courseName;
    private String description;
    private int credits;
    public String getId() { return id; }
    public String getCourseName() { return courseName; }
    public String getDescription() { return description; }
    public int getCredits() { return credits; }
}