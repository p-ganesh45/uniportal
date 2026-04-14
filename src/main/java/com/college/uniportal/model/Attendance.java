package com.college.uniportal.model;

import jakarta.persistence.*;

@Entity
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String usn;
    private String subject;
    private Integer percentage;
    private String date;

    // ✅ REQUIRED
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsn() { return usn; }
    public void setUsn(String usn) { this.usn = usn; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public Integer getPercentage() { return percentage; }
    public void setPercentage(Integer percentage) { this.percentage = percentage; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
}