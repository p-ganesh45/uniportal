package com.college.uniportal.model;

import jakarta.persistence.*;

@Entity
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;
    private String date;

    public Long getId() { return id; }
    public String getText() { return text; }
    public String getDate() { return date; }

    public void setId(Long id) { this.id = id; }
    public void setText(String text) { this.text = text; }
    public void setDate(String date) { this.date = date; }
}