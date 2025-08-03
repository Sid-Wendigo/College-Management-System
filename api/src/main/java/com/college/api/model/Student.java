package com.college.api.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
public class Student {
    @Id private String id;
    private String userId;
    private String firstName;
    private String lastName;
    private List<Mark> marks;
    private List<Fee> fees;
    private List<String> enrolledCourseIds;
    public String getId() { return id; }
    public String getUserId() { return userId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public List<Mark> getMarks() { return marks; }
    public List<Fee> getFees() { return fees; }
    public List<String> getEnrolledCourseIds() { return enrolledCourseIds; }
    public void setUserId(String userId) { this.userId = userId; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setMarks(List<Mark> marks) { this.marks = marks; }
    public void setFees(List<Fee> fees) { this.fees = fees; }
    public void setEnrolledCourseIds(List<String> ids) { this.enrolledCourseIds = ids; }
}