package com.college.uniportal.controller;

import com.college.uniportal.model.Student;
import com.college.uniportal.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/student")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService service;

    // ✅ LOGIN
    @PostMapping("/login")
    public Student login(@RequestBody Student s) {
        return service.login(s);
    }

    // ✅ REGISTER
    @PostMapping("/register")
    public Student register(@RequestBody Student s) {
        return service.register(s);
    }

    // ✅ GET STUDENT
    @GetMapping("/{usn}")
    public Student getStudent(@PathVariable String usn) {
        return service.getByUsn(usn);
    }

    // ✅ UPDATE
    @PutMapping("/update")
    public Student update(@RequestBody Student s) {
        return service.update(s);
    }
}