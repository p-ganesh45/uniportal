package com.college.uniportal.controller;

import com.college.uniportal.model.Student;
import com.college.uniportal.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService service;

    // ✅ GET STUDENT
    @GetMapping("/student/{usn}")
    public ResponseEntity<?> getStudent(@PathVariable String usn) {

        Student s = service.getByUsn(usn);

        if (s == null) {
            return ResponseEntity.status(404).body("Student not found");
        }

        return ResponseEntity.ok(s);
    }

    // ✅ LOGIN
    @PostMapping("/student/login")
    public ResponseEntity<?> login(@RequestBody Student s) {

        Student result = service.login(s);

        if (result == null) {
            return ResponseEntity.status(401).body("Invalid USN or password");
        }

        return ResponseEntity.ok(result);
    }

    // ✅ REGISTER
    @PostMapping("/student/register")
    public ResponseEntity<?> register(@RequestBody Student s) {

        Student result = service.register(s);

        if (result == null) {
            return ResponseEntity.status(409).body("Student already exists");
        }

        return ResponseEntity.ok(result);
    }

    // ✅ UPDATE
    @PutMapping("/student/update")
    public ResponseEntity<?> update(@RequestBody Student s) {

        Student updated = service.update(s);

        if (updated == null) {
            return ResponseEntity.status(404).body("Student not found");
        }

        return ResponseEntity.ok(updated);
    }
}