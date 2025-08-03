package com.college.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
    @Id private String id;
    @Indexed(unique = true) private String email;
    private String password;
    public User() {}
    public User(String email, String password) { this.email = email; this.password = password; }
    public String getId() { return id; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}