package com.college.api.model;

public class Mark {
    private String subject;
    private int score;
    public Mark(String subject, int score) { this.subject = subject; this.score = score; }
    public String getSubject() { return subject; }
    public int getScore() { return score; }
}