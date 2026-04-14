package com.college.uniportal.controller;

import com.college.uniportal.model.Student;
import com.college.uniportal.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentRepository repo;

    @GetMapping("/student/{usn}")
    public Student getStudent(@PathVariable String usn) {
        return repo.findByUsn(usn)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @PostMapping("/student/login")
    public Student login(@RequestBody Student s) {

        return repo.findByUsn(s.getUsn())
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }
    @PutMapping("/student/update")
    public Student update(@RequestBody Student s) {
        return repo.save(s);
    }
}