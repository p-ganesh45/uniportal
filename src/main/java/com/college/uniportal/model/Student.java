package com.college.uniportal.model;

import jakarta.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String usn;

    private String name;
    private String branch;
    private int year;

    // GETTERS & SETTERS
    public Long getId() { return id; }
    public String getUsn() { return usn; }
    public String getName() { return name; }
    public String getBranch() { return branch; }
    public int getYear() { return year; }

    public void setId(Long id) { this.id = id; }
    public void setUsn(String usn) { this.usn = usn; }
    public void setName(String name) { this.name = name; }
    public void setBranch(String branch) { this.branch = branch; }
    public void setYear(int year) { this.year = year; }
}