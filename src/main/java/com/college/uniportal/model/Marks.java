package com.college.uniportal.model;

import jakarta.persistence.*;

@Entity
public class Marks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String usn;
    private String subject;
    private Integer score;
    private String date;

    // ✅ REQUIRED GETTERS + SETTERS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsn() { return usn; }
    public void setUsn(String usn) { this.usn = usn; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public Integer getScore() { return score; }
    public void setScore(Integer score) { this.score = score; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
}